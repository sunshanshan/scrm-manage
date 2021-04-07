/*
 * 项目名称:platform-plus
 * 类名称:AbstractController.java
 * 包名称:com.platform.modules.sys.controller
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.sys.controller;

import com.platform.common.utils.Constant;
import com.platform.common.utils.ShiroUtils;
import com.platform.datascope.ContextHelper;
import com.platform.datascope.DataScope;
import com.platform.modules.sys.entity.SysRoleOrgEntity;
import com.platform.modules.sys.entity.SysUserEntity;
import com.platform.modules.sys.service.SysRoleOrgService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller公共组件
 *
 * @author 李鹏军
 */
@Slf4j
public abstract class AbstractController {
    protected Logger logger = log;

    @Autowired
    private SysRoleOrgService sysRoleOrgService;

    /**
     * 当前登录用户
     *
     * @return SysUserEntity
     */
    protected SysUserEntity getUser() {
        return ShiroUtils.getUserEntity();
    }

    /**
     * 当前登录用户ID
     *
     * @return userId
     */
    protected String getUserId() {
        return getUser().getUserId();
    }

    /**
     * 当前登录用户所属机构
     *
     * @return orgNo
     */
    protected String getOrgNo() {
        return getUser().getOrgNo();
    }

    /**
     * 数据权限构造
     *
     * @return DataScope
     */
    protected DataScope getDataScope() {
        DataScope dataScope = new DataScope();
        dataScope.setOrgNos(sysRoleOrgService.queryOrgNoListByUserId(getUserId()));
        return dataScope;
    }

    /**
     * 数据权限构造
     *
     * @return DataScope
     */
    protected DataScope getDataScope(String userAlias, String orgAlias) {
        DataScope dataScope = new DataScope();
        dataScope.setUserAlias(userAlias);
        dataScope.setOrgAlias(orgAlias);
        dataScope.setOrgNos(sysRoleOrgService.queryOrgNoListByUserId(getUserId()));
        return dataScope;
    }

    /**
     * 数据权限构造
     * userPerm 权限字符串 userAlias 添加人表字段名 orgAlias添加人部门名 userId 会员所属人
     * @return DataScope
     */
    protected DataScope getDataScope(String userPerm, String userAlias, String orgAlias, String userId) {
        DataScope dataScope = new DataScope();
        dataScope.setUserPerm(userPerm);
        dataScope.setUserAlias(userAlias);
        dataScope.setOrgAlias(orgAlias);
        dataScope.setUserId(userId);

        // 根据权限和用户id取出角色对应的部门id
        dataScope.setOrgNos(sysRoleOrgService.queryOrgNoListByUserIdAndPerm(getUserId(), userPerm));
        return dataScope;
    }


    /**
     * 数据权限构造孙珊珊
     * 权限字符串 userAlias 添加人表字段名 orgAlias添加人部门名 userId 会员所属人
     * @return DataScope
     */
    protected DataScope getDataScopeContex(String userPerm,String userAlias, String orgAlias) {
        DataScope dataScope = new DataScope();
        dataScope.setUserAlias(userAlias);
        dataScope.setOrgAlias(orgAlias);

        //拼接部门
        if (!Constant.SUPER_ADMIN.equals(getUserId()) && !Constant.SUPER_ADMIN2.equals(getUserId()) ) {
            List<SysRoleOrgEntity> sros = new ArrayList<>();
            Map<String, Object> m = new HashMap<>();
            m.put("userId", getUserId());
            m.put("userPerm", userPerm);
            sros = sysRoleOrgService.queryOrgNoIsselect(m);
            String orgs = ContextHelper.setSearchDeptPermit4Search(sros, getOrgNo());
            dataScope.setOrgNos(orgs);
        }
        return dataScope;
    }
}
