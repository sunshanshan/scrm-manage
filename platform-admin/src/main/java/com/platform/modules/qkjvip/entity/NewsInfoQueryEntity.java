/*
 * 项目名称:platform-plus
 * 类名称:NewsEntity.java
 * 包名称:com.platform.modules.qkjvip.entity
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2021/3/11 13:12            liuqianru    初版做成
 *
 */
package com.platform.modules.qkjvip.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * NewsInfoQueryEntity
 *
 * @author liuqianru
 * @date 2021/3/11 13:12
 */
@Data
public class NewsInfoQueryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer newsid;
}
