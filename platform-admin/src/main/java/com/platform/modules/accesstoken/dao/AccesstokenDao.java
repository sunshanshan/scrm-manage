/*
 * 项目名称:platform-plus
 * 类名称:AccesstokenDao.java
 * 包名称:com.platform.modules.accesstoken.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-12-04 16:54:30        孙珊珊     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.accesstoken.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.platform.modules.accesstoken.entity.AccesstokenEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Dao
 *
 * @author 孙珊珊
 * @date 2019-12-04 16:54:30
 */
@Mapper
public interface AccesstokenDao extends BaseMapper<AccesstokenEntity> {

    /**
     * 查询所有列表
     *
     * @param params 查询参数
     * @return List
     */
    List<AccesstokenEntity> queryAll(@Param("params") Map<String, Object> params);

    /**
     * 自定义分页查询
     *
     * @param page   分页参数
     * @param params 查询参数
     * @return List
     */
    List<AccesstokenEntity> selectAccesstokenPage(IPage page, @Param("params") Map<String, Object> params);
}
