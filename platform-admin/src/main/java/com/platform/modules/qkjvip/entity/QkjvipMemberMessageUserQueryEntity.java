/*
 * 项目名称:platform-plus
 * 类名称:QkjvipMemberIntegraluserEntity.java
 * 包名称:com.platform.modules.qkjvip.entity
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2020-12-21 15:18:24        liuqianru     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.qkjvip.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体
 *
 * @author liuqianru
 * @date 2020-12-21 15:18:24
 */
@Data
public class QkjvipMemberMessageUserQueryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private String memberId;

    /**
     * openid
     */
    private String openid;

    /**
     * mobile
     */
    private String mobile;
}
