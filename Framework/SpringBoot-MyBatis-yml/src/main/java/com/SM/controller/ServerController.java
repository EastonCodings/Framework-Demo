package com.SM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SM.entity.Server;
import com.SM.service.ServerService;

@RestController
public class ServerController {

    @Autowired
    private ServerService serverService;

    /**
     * 検索
     *
     * @return
     */
    @RequestMapping(value = "/servers", method = RequestMethod.GET)
    public List<Server> F01() {
        List<Server> ServerList = serverService.getServer();
        System.out.println(ServerList);
        return ServerList;
    }
}
