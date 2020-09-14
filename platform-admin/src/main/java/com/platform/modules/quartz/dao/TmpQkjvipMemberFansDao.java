/*
 * 项目名称:platform-plus
 * 类名称:TmpQkjvipMemberFansDao.java
 * 包名称:com.platform.modules.tmp.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2020-09-14 13:51:21        liuqianru     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.quartz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.platform.modules.quartz.entity.TmpQkjvipMemberFansEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Dao
 *
 * @author liuqianru
 * @date 2020-09-14 13:51:21
 */
@Mapper
public interface TmpQkjvipMemberFansDao extends BaseMapper<TmpQkjvipMemberFansEntity> {

    /**
     * 清空粉丝临时表
     */
    int deleteAll();
}
