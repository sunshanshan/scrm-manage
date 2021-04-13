/*
 * 项目名称:platform-plus
 * 类名称:QkjvipContentPushchannelServiceImpl.java
 * 包名称:com.platform.modules.qkjvip.service.impl
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2021-03-24 15:41:46        liuqianru     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.qkjvip.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.utils.Query;
import com.platform.modules.qkjvip.dao.QkjvipContentPushchannelDao;
import com.platform.modules.qkjvip.entity.QkjvipContentPushchannelEntity;
import com.platform.modules.qkjvip.service.QkjvipContentPushchannelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author liuqianru
 * @date 2021-03-24 15:41:46
 */
@Service("qkjvipContentPushchannelService")
public class QkjvipContentPushchannelServiceImpl extends ServiceImpl<QkjvipContentPushchannelDao, QkjvipContentPushchannelEntity> implements QkjvipContentPushchannelService {

    @Override
    public List<QkjvipContentPushchannelEntity> queryAll(Map<String, Object> params) {
        return baseMapper.queryAll(params);
    }

    @Override
    public Page queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "T.id");
        params.put("asc", false);
        Page<QkjvipContentPushchannelEntity> page = new Query<QkjvipContentPushchannelEntity>(params).getPage();
        page.setRecords(baseMapper.selectQkjvipContentPushchannelPage(page, params));
        page.setTotal(baseMapper.queryAll(params).size());
        return page;
    }

    @Override
    public boolean add(QkjvipContentPushchannelEntity qkjvipContentPushchannel) {
        return this.save(qkjvipContentPushchannel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBatch(List<QkjvipContentPushchannelEntity> pushChannelList) {
        this.saveBatch(pushChannelList);
    }

    @Override
    public boolean update(QkjvipContentPushchannelEntity qkjvipContentPushchannel) {
        return this.updateById(qkjvipContentPushchannel);
    }

    @Override
    public boolean delete(String id) {
        return this.removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteBatch(String[] ids) {
        return this.removeByIds(Arrays.asList(ids));
    }

    @Override
    public boolean deleteByGroupId(String groupId) {
        return baseMapper.deleteByGroupId(groupId);
    }
}
