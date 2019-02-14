package cn.bigfish.syna.modular.manage.controller;

import cn.bigfish.syna.core.common.exception.BizExceptionEnum;
import cn.bigfish.syna.core.log.LogObjectHolder;
import cn.bigfish.syna.modular.manage.service.IUPassportService;
import cn.bigfish.syna.modular.manage.warpper.UPassportWarpper;
import cn.bigfish.syna.modular.system.model.UPassport;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 用户通行证控制器
 *
 * @author shenyu
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
        List<Map<String,Object>> uPassports = uPassportService.selectUPassports(null);
        return new UPassportWarpper(uPassports).wrap();
    }

    /**
     * 新增用户通行证
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@Valid UPassport uPassport,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
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
