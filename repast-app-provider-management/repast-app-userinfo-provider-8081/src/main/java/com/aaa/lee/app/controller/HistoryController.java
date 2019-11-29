package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.History;
import com.aaa.lee.app.service.HistoryService;
import com.aaa.lee.app.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 查询积分明细
 * @author Administrator
 */
@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private RedisService redisService;

    @PostMapping("/selectId")
    public List<History> selectId(){
      return   historyService.selectId(redisService);
    };


}
