package cn.bigfish.syna.modular.manage.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.bigfish.syna.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.bigfish.syna.modular.system.model.Content;
import cn.bigfish.syna.modular.manage.service.IContentService;

/**
 * 内容管理控制器
 *
 * @author fengshuonan
 * @Date 2019-02-18 12:07:03
 */
@Controller
@RequestMapping("/content")
public class ContentController extends BaseController {

    private String PREFIX = "/manage/content/";

    @Autowired
    private IContentService contentService;

    /**
     * 跳转到内容管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "content.html";
    }

    /**
     * 跳转到添加内容管理
     */
    @RequestMapping("/content_add")
    public String contentAdd() {
        return PREFIX + "content_add.html";
    }

    /**
     * 跳转到修改内容管理
     */
    @RequestMapping("/content_update/{contentId}")
    public String contentUpdate(@PathVariable Integer contentId, Model model) {
        Content content = contentService.selectById(contentId);
        model.addAttribute("item",content);
        LogObjectHolder.me().set(content);
        return PREFIX + "content_edit.html";
    }

    /**
     * 获取内容管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return contentService.selectList(null);
    }

    /**
     * 新增内容管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Content content) {
        contentService.insert(content);
        return SUCCESS_TIP;
    }

    /**
     * 删除内容管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer contentId) {
        contentService.deleteById(contentId);
        return SUCCESS_TIP;
    }

    /**
     * 修改内容管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Content content) {
        contentService.updateById(content);
        return SUCCESS_TIP;
    }

    /**
     * 内容管理详情
     */
    @RequestMapping(value = "/detail/{contentId}")
    @ResponseBody
    public Object detail(@PathVariable("contentId") Integer contentId) {
        return contentService.selectById(contentId);
    }
}
