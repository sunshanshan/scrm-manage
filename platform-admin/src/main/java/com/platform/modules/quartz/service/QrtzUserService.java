/*
 * 项目名称:platform-plus
 * 类名称:OrgUserService.java
 * 包名称:com.platform.modules.quartz.service
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2020/3/25 15:06            liuqianru    初版做成
 *
 */
package com.platform.modules.quartz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.modules.quartz.entity.QrtzUserEntity;

import java.util.List;
import java.util.Map;

/**
 * UserService
 *
 * @author liuqianru
 * @date 2020/3/25 15:06
 */
public interface QrtzUserService extends IService<QrtzUserEntity> {
    /**
     * 查询所有
     *
     * @param params 查询参数
     * @return List
     */
    List<QrtzUserEntity> queryAll(Map<String, Object> params);
}
