/**
 * 用户通行证管理初始化
 */
var UPassport = {
    id: "UPassportTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
UPassport.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键ID', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '登录名', field: 'loginName', visible: true, align: 'center', valign: 'middle'},
            {title: '邮箱', field: 'email', visible: true, align: 'center', valign: 'middle'},
            {title: '手机', field: 'telephone', visible: true, align: 'center', valign: 'middle'},
            {title: '密码', field: 'password', visible: true, align: 'center', valign: 'middle'},
            {title: '登录盐值', field: 'salt', visible: true, align: 'center', valign: 'middle'},
            {title: '注册时间', field: 'regTime', visible: true, align: 'center', valign: 'middle'},
            {title: '注册IP', field: 'regIp', visible: true, align: 'center', valign: 'middle'},
            {title: '注册方式', field: 'regType', visible: true, align: 'center', valign: 'middle'},
            {title: '注册类型', field: 'regFrom', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '冻结原因', field: 'reason', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'memo', visible: true, align: 'center', valign: 'middle'},
            {title: '是否测试', field: 'isTest', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
UPassport.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        UPassport.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户通行证
 */
UPassport.openAddUPassport = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户通行证',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/uPassport/uPassport_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户通行证详情
 */
UPassport.openUPassportDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户通行证详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/uPassport/uPassport_update/' + UPassport.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户通行证
 */
UPassport.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/uPassport/delete", function (data) {
            Feng.success("删除成功!");
            UPassport.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("uPassportId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户通行证列表
 */
UPassport.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    UPassport.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = UPassport.initColumn();
    var table = new BSTable(UPassport.id, "/uPassport/list", defaultColunms);
    table.setPaginationType("client");
    UPassport.table = table.init();
});
