/**
 * 初始化用户通行证详情对话框
 */
var UPassportInfoDlg = {
    uPassportInfoData : {}
};

/**
 * 清除数据
 */
UPassportInfoDlg.clearData = function() {
    this.uPassportInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UPassportInfoDlg.set = function(key, val) {
    this.uPassportInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
UPassportInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
UPassportInfoDlg.close = function() {
    parent.layer.close(window.parent.UPassport.layerIndex);
}

/**
 * 收集数据
 */
UPassportInfoDlg.collectData = function() {
    this
    .set('id')
    .set('loginName')
    .set('email')
    .set('telephone')
    .set('password')
    .set('salt')
    .set('regTime')
    .set('regIp')
    .set('regType')
    .set('regFrom')
    .set('status')
    .set('reason')
    .set('memo')
    .set('isTest');
}

/**
 * 提交添加
 */
UPassportInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/uPassport/add", function(data){
        Feng.success("添加成功!");
        window.parent.UPassport.table.refresh();
        UPassportInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.uPassportInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
UPassportInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/uPassport/update", function(data){
        Feng.success("修改成功!");
        window.parent.UPassport.table.refresh();
        UPassportInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.uPassportInfoData);
    ajax.start();
}

$(function() {

});
