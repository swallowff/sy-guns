/**
 * 内容管理管理初始化
 */
var Content = {
    id: "ContentTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Content.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'tittle', visible: true, align: 'center', valign: 'middle'},
            {title: '缩略图', field: 'thumbImg', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '作者ID', field: 'authorId', visible: true, align: 'center', valign: 'middle'},
            {title: '内容类型', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '格式化类型', field: 'fmtType', visible: true, align: 'center', valign: 'middle'},
            {title: '标签', field: 'tags', visible: true, align: 'center', valign: 'middle'},
            {title: '分类', field: 'categories', visible: true, align: 'center', valign: 'middle'},
            {title: '点击量', field: 'hits', visible: true, align: 'center', valign: 'middle'},
            {title: '允许评论', field: 'allowComment', visible: true, align: 'center', valign: 'middle'},
            {title: '评论数', field: 'commentNum', visible: true, align: 'center', valign: 'middle'},
            {title: '收藏数', field: 'collectNum', visible: true, align: 'center', valign: 'middle'},
            {title: '版本', field: 'version', visible: true, align: 'center', valign: 'middle'},
            {title: '创建者', field: 'createBy', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createDate', visible: true, align: 'center', valign: 'middle'},
            {title: '更新者', field: 'updateBy', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateDate', visible: true, align: 'center', valign: 'middle'},
            {title: '备注信息', field: 'remarks', visible: true, align: 'center', valign: 'middle'},
            {title: '删除标记', field: 'delFlag', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Content.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Content.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加内容管理
 */
Content.openAddContent = function () {
    var index = layer.open({
        type: 2,
        title: '添加内容管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/content/content_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看内容管理详情
 */
Content.openContentDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '内容管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/content/content_update/' + Content.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除内容管理
 */
Content.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/content/delete", function (data) {
            Feng.success("删除成功!");
            Content.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("contentId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询内容管理列表
 */
Content.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Content.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Content.initColumn();
    var table = new BSTable(Content.id, "/content/list", defaultColunms);
    table.setPaginationType("client");
    Content.table = table.init();
});
