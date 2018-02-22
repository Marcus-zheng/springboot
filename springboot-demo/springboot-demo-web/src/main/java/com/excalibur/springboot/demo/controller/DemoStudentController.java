package com.excalibur.springboot.demo.controller;

import com.excalibur.springboot.base.vo.ResultMsg;
import com.excalibur.springboot.demo.dao.DemoStudentDao;
import com.excalibur.springboot.demo.model.DemoStudent;
import com.excalibur.springboot.demo.service.DemoStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mingfa.zheng
 * @date: 2018/2/17 8:09
 */
@RestController
@RequestMapping(value = "/demo/student")
public class DemoStudentController {
    @Autowired
    private DemoStudentService demoStudentService;
    @Autowired
    private DemoStudentDao demoStudentDao;

    @GetMapping(value = "/getById")
    public ResultMsg getById(String id){
        System.out.println("-----id------:{}" + id);
        ResultMsg resultMsg = new ResultMsg();
        DemoStudent demoStudent = demoStudentDao.findOne(id);
        resultMsg.setData(demoStudent);
        return resultMsg;
    }

    @PostMapping(value = "/save")
    public ResultMsg save(DemoStudent demoStudent){
        System.out.println("-------save---------");
        return new ResultMsg(demoStudentDao.save(demoStudent));
    }
}
