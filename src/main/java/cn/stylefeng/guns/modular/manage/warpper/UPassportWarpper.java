package cn.stylefeng.guns.modular.manage.warpper;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

/**
 * @author shenyu
 * @create 2019/2/13
 */
public class UPassportWarpper extends BaseControllerWrapper {

    public UPassportWarpper(Map<String, Object> single) {
        super(single);
    }

    public UPassportWarpper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public UPassportWarpper(Page<Map<String, Object>> page) {
        super(page);
    }

    public UPassportWarpper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        map.put("test", ConstantFactory.me().getDictsByName("是否",(Integer) map.get("test")));
    }
}
