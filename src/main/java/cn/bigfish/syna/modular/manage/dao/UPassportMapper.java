package cn.bigfish.syna.modular.manage.dao;

import cn.bigfish.syna.modular.manage.model.UPassport;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户通行证表 Mapper 接口
 * </p>
 *
 * @author yu
 * @since 2018-12-19
 */
public interface UPassportMapper extends BaseMapper<UPassport> {

    List<Map<String,Object>> selectUPassports(Object o);
}
