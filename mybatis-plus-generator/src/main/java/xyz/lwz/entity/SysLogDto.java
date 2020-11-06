package xyz.lwz.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import static com.baomidou.mybatisplus.annotation.FieldStrategy.NOT_EMPTY;

/**
 * <p>
 * 日志记录表
 * </p>
 *
 * @author liwz
 * @since 2020-11-06
 */
@Data
@TableName(value = "tsys_log")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SysLogDto implements Serializable {

    private static final long serialVersionUID = 6035175639727375801L;

    /**
     * URID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String urid;

    /**
     * 租户ID
     */
    private Integer tenantid;

    /**
     * 组织ID
     */
    private String orgid;

    /**
     * QA:交易编号
     */
    private String transcode;

    /**
     * 子交易编号
     */
    private String subtranscode;

    /**
     * 业务类型
     */
    @TableField(whereStrategy = NOT_EMPTY)
    private String businesstype;

    /**
     * 业务数据URID
     */
    @TableField(whereStrategy = NOT_EMPTY)
    private String businessurid;
    /**
     * 请求路径
     */
    private String url;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 业务操作详细描述
     */
    private String content;

    /**
     * 返回状态
     */
    private String status;

    /**
     * 返回结果
     */
    private String results;

    /**
     * 创建人
     */
    private String createdby;

    /**
     * 创建时间
     */
    private Date createdon;

    /**
     * 操作者ip地址
     */
    private String ipaddress;


}
