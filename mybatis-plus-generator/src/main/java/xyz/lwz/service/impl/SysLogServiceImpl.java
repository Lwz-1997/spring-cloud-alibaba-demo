package xyz.lwz.service.impl;

import xyz.lwz.entity.SysLogDto;
import xyz.lwz.mapper.SysLogMapper;
import xyz.lwz.service.SysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志记录表 服务实现类
 * </p>
 *
 * @author liwz
 * @since 2020-11-06
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogDto> implements SysLogService {

}
