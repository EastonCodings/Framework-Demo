package com.SM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SM.entity.Server;
import com.SM.service.ServerService;

@RestController
// @RestController 注解相当于@ResponseBody ＋ @Controller合在一起的作用
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
        return ServerList;
    }
}



/*[
 {
     "id": 3,
     "warehouseName": "dw_ichikawa",
     "slackGroup": "rs-eng_bot-dw",
     "recipientSlackid": "UAMF5LQCE",
     "emailAddress": "nantian_test@groundinc.co.jp/nantian01",
     "state": "1",
     "createdAt": "2018-09-20T03:31:42.000+0000",
     "createdBy": 1,
     "modifiedAt": "2018-09-21T02:30:23.000+0000",
     "modifiedBy": 1,
     "deleteFlag": "0"
 },
 {
     "id": 1,
     "warehouseName": "hl_ibaraki",
     "slackGroup": "rs-eng_bot-hl",
     "recipientSlackid": "UAMF5LQCE,U85M87UM6",
     "emailAddress": "nantian_test@groundinc.co.jp/nantian01",
     "state": "0",
     "createdAt": "2018-09-18T09:16:46.000+0000",
     "createdBy": 1,
     "modifiedAt": "2018-09-18T09:59:59.000+0000",
     "modifiedBy": 1,
     "deleteFlag": "0"
 },
 {
     "id": 2,
     "warehouseName": "as_shinsuna",
     "slackGroup": "rs-eng_bot-as",
     "recipientSlackid": "U87DDE35M",
     "emailAddress": "nantian_test@groundinc.co.jp/nantian01",
     "state": "1",
     "createdAt": "2018-09-18T09:16:49.000+0000",
     "createdBy": 1,
     "modifiedAt": "2018-09-18T09:16:49.000+0000",
     "modifiedBy": 1,
     "deleteFlag": "0"
 }
]*/