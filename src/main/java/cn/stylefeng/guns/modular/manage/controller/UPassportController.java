package cn.stylefeng.guns.modular.manage.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.UPassport;
import cn.stylefeng.guns.modular.manage.service.IUPassportService;

/**
 * 用户通行证控制器
 *
 * @author fengshuonan
 * @Date 2018-12-19 16:16:00
 */
@Controller
@RequestMapping("/uPassport")
public class UPassportController extends BaseController {

    private String PREFIX = "/manage/uPassport/";

    @Autowired
    private IUPassportService uPassportService;

    /**
     * 跳转到用户通行证首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "uPassport.html";
    }

    /**
     * 跳转到添加用户通行证
     */
    @RequestMapping("/uPassport_add")
    public String uPassportAdd() {
        return PREFIX + "uPassport_add.html";
    }

    /**
     * 跳转到修改用户通行证
     */
    @RequestMapping("/uPassport_update/{uPassportId}")
    public String uPassportUpdate(@PathVariable Integer uPassportId, Model model) {
        UPassport uPassport = uPassportService.selectById(uPassportId);
        model.addAttribute("item",uPassport);
        LogObjectHolder.me().set(uPassport);
        return PREFIX + "uPassport_edit.html";
    }

    /**
     * 获取用户通行证列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return uPassportService.selectList(null);
    }

    /**
     * 新增用户通行证
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(UPassport uPassport) {
        uPassportService.insert(uPassport);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户通行证
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer uPassportId) {
        uPassportService.deleteById(uPassportId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户通行证
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(UPassport uPassport) {
        uPassportService.updateById(uPassport);
        return SUCCESS_TIP;
    }

    /**
     * 用户通行证详情
     */
    @RequestMapping(value = "/detail/{uPassportId}")
    @ResponseBody
    public Object detail(@PathVariable("uPassportId") Integer uPassportId) {
        return uPassportService.selectById(uPassportId);
    }
}
