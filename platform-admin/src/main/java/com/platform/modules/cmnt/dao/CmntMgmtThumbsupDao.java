/*
 * 项目名称:platform-plus
 * 类名称:CmntMgmtThumbsupDao.java
 * 包名称:com.platform.modules.cmnt.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2021-05-25 17:16:10        liuqianru     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.cmnt.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.platform.modules.cmnt.entity.CmntMgmtThumbsupEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Dao
 *
 * @author liuqianru
 * @date 2021-05-25 17:16:10
 */
@Mapper
public interface CmntMgmtThumbsupDao extends BaseMapper<CmntMgmtThumbsupEntity> {

    /**
     * 查询所有列表
     *
     * @param params 查询参数
     * @return List
     */
    List<CmntMgmtThumbsupEntity> queryAll(@Param("params") Map<String, Object> params);

    /**
     * 自定义分页查询
     *
     * @param page   分页参数
     * @param params 查询参数
     * @return List
     */
    List<CmntMgmtThumbsupEntity> selectCmntMgmtThumbsupPage(IPage page, @Param("params") Map<String, Object> params);

    boolean doDelete(CmntMgmtThumbsupEntity cmntMgmtThumbsup);
}
