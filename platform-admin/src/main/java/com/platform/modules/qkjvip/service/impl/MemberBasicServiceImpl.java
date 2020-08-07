/*
 * 项目名称:platform-plus
 * 类名称:MemberBasicServiceImpl.java
 * 包名称:com.platform.modules.qkjvip.service.impl
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2020/8/7 15:48            liuqianru    初版做成
 *
 */
package com.platform.modules.qkjvip.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.modules.qkjvip.dao.MemberBasicDao;
import com.platform.modules.qkjvip.dao.MemberDao;
import com.platform.modules.qkjvip.entity.MemberBasicEntity;
import com.platform.modules.qkjvip.entity.MemberEntity;
import com.platform.modules.qkjvip.service.MemberBasicService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * MemberBasicServiceImpl
 *
 * @author liuqianru
 * @date 2020/8/7 15:48
 */
@Service("memberBasicService")
public class MemberBasicServiceImpl extends ServiceImpl<MemberBasicDao, MemberBasicEntity> implements MemberBasicService {
    @Override
    public void saveOrUpdate(List<MemberBasicEntity> mbList) {
        this.saveBatch(mbList);
    }
}
