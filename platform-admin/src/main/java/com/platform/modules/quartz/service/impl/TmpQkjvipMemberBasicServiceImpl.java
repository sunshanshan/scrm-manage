/*
 * 项目名称:platform-plus
 * 类名称:TmpQkjvipMemberBasicServiceImpl.java
 * 包名称:com.platform.modules.tmp.service.impl
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2020-08-20 14:33:13        liuqianru     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.quartz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.modules.quartz.dao.TmpQkjvipMemberBasicDao;
import com.platform.modules.quartz.entity.TmpQkjvipMemberBasicEntity;
import com.platform.modules.quartz.service.TmpQkjvipMemberBasicService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service实现类
 *
 * @author liuqianru
 * @date 2020-08-20 14:33:13
 */
@Service("tmpQkjvipMemberBasicService")
public class TmpQkjvipMemberBasicServiceImpl extends ServiceImpl<TmpQkjvipMemberBasicDao, TmpQkjvipMemberBasicEntity> implements TmpQkjvipMemberBasicService {

    @Override
    public void addBatch(List<TmpQkjvipMemberBasicEntity> mbList) {
        //批量插入前先清空临时表
        baseMapper.deleteAll();
        this.saveBatch(mbList);
    }
}
