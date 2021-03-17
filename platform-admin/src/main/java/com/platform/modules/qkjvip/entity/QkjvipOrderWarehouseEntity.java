/*
 * 项目名称:platform-plus
 * 类名称:QkjvipOrderWarehouseEntity.java
 * 包名称:com.platform.modules.qkjvip.entity
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2021-03-15 15:49:03        孙珊珊     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.qkjvip.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 *
 * @author 孙珊珊
 * @date 2021-03-15 15:49:03
 */
@Data
@TableName("QKJVIP_ORDER_WAREHOUSE")
public class QkjvipOrderWarehouseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    @TableId
    private String id;
    /**
     * HouseName
     */
    private String housename;
    /**
     * Address
     */
    private String address;
    /**
     * Remark
     */
    private String remark;
    /**
     * Disabled
     */
    private Boolean disabled;
    /**
     * Creator
     */
    private String creator;
    /**
     * CreateOn
     */
    private Date createon;
}
