/*
 * 项目名称:platform-plus
 * 类名称:QkjvipOrderErporderController.java
 * 包名称:com.platform.modules.qkjvip.controller
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2021-06-21 09:21:21        孙珊珊     初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.qkjvip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.common.annotation.SysLog;
import com.platform.common.utils.RestResponse;
import com.platform.modules.sys.controller.AbstractController;
import com.platform.modules.qkjvip.entity.QkjvipOrderErporderEntity;
import com.platform.modules.qkjvip.service.QkjvipOrderErporderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author 孙珊珊
 * @date 2021-06-21 09:21:21
 */
@RestController
@RequestMapping("qkjvip/ordererporder")
public class QkjvipOrderErporderController extends AbstractController {
    @Autowired
    private QkjvipOrderErporderService qkjvipOrderErporderService;

    /**
     * 查看所有列表
     *
     * @param params 查询参数
     * @return RestResponse
     */
    @RequestMapping("/queryAll")
    public RestResponse queryAll(@RequestParam Map<String, Object> params) {
        List<QkjvipOrderErporderEntity> list = qkjvipOrderErporderService.queryAll(params);

        return RestResponse.success().put("list", list);
    }

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return RestResponse
     */
    @GetMapping("/list")
    public RestResponse list(@RequestParam Map<String, Object> params) {
        params.put("isnotcrmorder","1");
        Page page = qkjvipOrderErporderService.queryPage(params);
        List<QkjvipOrderErporderEntity> list = qkjvipOrderErporderService.queryAllDetail(params);
        return RestResponse.success().put("page", page).put("detailList",list);
    }

    /**
     * 根据主键查询详情
     *
     * @param id 主键
     * @return RestResponse
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("qkjvip:ordererporder:info")
    public RestResponse info(@PathVariable("id") String id) {
        QkjvipOrderErporderEntity qkjvipOrderErporder = qkjvipOrderErporderService.getById(id);

        return RestResponse.success().put("ordererporder", qkjvipOrderErporder);
    }

    /**
     * 新增
     *
     * @param qkjvipOrderErporder qkjvipOrderErporder
     * @return RestResponse
     */
    @SysLog("新增")
    @RequestMapping("/save")
    @RequiresPermissions("qkjvip:ordererporder:save")
    public RestResponse save(@RequestBody QkjvipOrderErporderEntity qkjvipOrderErporder) {

        qkjvipOrderErporderService.add(qkjvipOrderErporder);

        return RestResponse.success();
    }

    /**
     * 修改
     *
     * @param qkjvipOrderErporder qkjvipOrderErporder
     * @return RestResponse
     */
    @SysLog("修改")
    @RequestMapping("/update")
    @RequiresPermissions("qkjvip:ordererporder:update")
    public RestResponse update(@RequestBody QkjvipOrderErporderEntity qkjvipOrderErporder) {

        qkjvipOrderErporderService.update(qkjvipOrderErporder);

        return RestResponse.success();
    }

    /**
     * 根据主键删除
     *
     * @param ids ids
     * @return RestResponse
     */
    @SysLog("删除")
    @RequestMapping("/delete")
    @RequiresPermissions("qkjvip:ordererporder:delete")
    public RestResponse delete(@RequestBody String[] ids) {
        qkjvipOrderErporderService.deleteBatch(ids);

        return RestResponse.success();
    }
}
