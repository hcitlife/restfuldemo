package com.hc.controller;

import com.hc.bean.Result;
import com.hc.bean.ResultCode;
import com.hc.bean.ResultUtil;
import com.hc.db.DeptTable;
import com.hc.domain.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 梁云亮
 * @Date 2020/5/24 15:34
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/rest")
public class DeptController {
    //增加Dept ，使用POST方法
    @PostMapping(value = "/v1/dept")
    public Result saveDept(@RequestBody Dept dept) {
        boolean res = DeptTable.insert(dept);
        log.info("saveDept：{}", dept);
        DeptTable.selectAll().forEach(System.out::println);
        if (res) {
            return ResultUtil.success(dept);
        } else {
            return ResultUtil.fail(ResultCode.SERVER_FAIL);
        }
    }

    //更新Dept，使用PUT方法
    @PutMapping(value = "/v1/dept")
    public Result updateDept(@RequestBody Dept dept) {
        boolean flag = DeptTable.update(dept);//表示用户要删除的deptno不存在
        log.info("updateDept：{}", dept);
        DeptTable.selectAll().forEach(System.out::println);
        if (flag) {
            return ResultUtil.success(dept);
        } else {
            return ResultUtil.fail(ResultCode.SERVER_FAIL);
        }
    }

    //删除Dept，使用DELETE方法
    @DeleteMapping(value = "/v1/{deptno}")
    public Result deleteDept(@PathVariable Integer deptno) {
        boolean flag = DeptTable.delete(deptno);
        log.info("deleteDept：{}", deptno);
        DeptTable.selectAll().forEach(System.out::println);
        if (flag) {
            return ResultUtil.success(deptno);
        } else {
            return ResultUtil.fail(ResultCode.CLIENT_FAIL);
        }
    }

    //获取Dept，使用GET方法
    @GetMapping(value = "/v2/{deptno}")
    public Result getDept(@PathVariable Integer deptno) {
        Dept dept = DeptTable.select(deptno);
        if (dept != null) {
            return ResultUtil.success(dept);
        } else {
            return ResultUtil.success(ResultCode.SERVER_FAIL);
        }
    }

    @GetMapping("all")
    public List<Dept> getAllDept() {
        List<Dept> depts = DeptTable.selectAll();
        return depts;
    }
}