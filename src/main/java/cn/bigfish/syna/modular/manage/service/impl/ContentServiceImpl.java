package cn.bigfish.syna.modular.manage.service.impl;

import cn.bigfish.syna.modular.manage.model.Content;
import cn.bigfish.syna.modular.manage.dao.ContentMapper;
import cn.bigfish.syna.modular.manage.service.IContentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容管理 服务实现类
 * </p>
 *
 * @author yu.shen
 * @since 2019-02-18
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {

}
