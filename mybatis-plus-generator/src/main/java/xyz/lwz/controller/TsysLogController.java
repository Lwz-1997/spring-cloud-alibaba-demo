package xyz.lwz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.lwz.entity.SysLogDto;
import xyz.lwz.service.SysLogService;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 日志记录表 前端控制器
 * </p>
 *
 * @author liwz
 * @since 2020-11-06
 */
@RestController
@RequestMapping("/sysLog")
public class TsysLogController {

    @Resource
    private SysLogService sysLogService;

    @GetMapping(value = "hello")
    String hello() {
        return "hello Nacos!";
    }

    @GetMapping(value = "1")
    public Object list() {
        return sysLogService.list();
    }

    @GetMapping(value = "2")
    public Object insert() throws UnknownHostException {
        SysLogDto sysLogDto = new SysLogDto();
        sysLogDto.setIpaddress(InetAddress.getLocalHost()
                .getHostAddress()).setBusinessurid("2")
                .setTenantid(2).setOrgid("2").setBusinesstype(UUID.randomUUID().toString().substring(1,5)).setUrl("2").setParams("ww").setContent("www").setStatus("www").setResults("wqq").setCreatedby("qwqq00").setCreatedon(new Date());
        return sysLogService.save(sysLogDto);
    }

    @GetMapping(value = "3")
    public Object query(){
        SysLogDto sysLogDto = new SysLogDto();
        sysLogDto.setBusinessurid("1").setBusinesstype(null);
        QueryWrapper<SysLogDto> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(SysLogDto::getBusinesstype, sysLogDto.getBusinesstype())
                .eq(SysLogDto::getBusinessurid, sysLogDto.getBusinessurid());
        return sysLogService.list(queryWrapper);
    }
}
