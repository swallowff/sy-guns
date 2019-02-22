package cn.bigfish.syna.modular.manage.service;

import cn.bigfish.syna.modular.manage.model.UPassport;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户通行证表 服务类
 * </p>
 *
 * @author yu
 * @since 2018-12-19
 */
public interface IUPassportService extends IService<UPassport> {

    List<Map<String,Object>> selectUPassports(Object o);
}
