package com.SM.dao.ext;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.SM.entity.Server;

public interface ServerExtMapper {

    @Select("select * from server")
    // @Result 结果集标识，用来对应数据库列名的，如果实体类属性和数据库属性名保持一致，可以忽略此参数
    @Results({
            @Result(property = "warehouseName", column = "warehouse_name"),
            @Result(property = "slackGroup", column = "slack_group"),
            @Result(property = "recipientSlackid", column = "recipient_slackId"),
            @Result(property = "emailAddress", column = "email_address"),
            @Result(property = "state", column = "state"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "createdBy", column = "created_by"),
            @Result(property = "modifiedAt", column = "modified_at"),
            @Result(property = "modifiedBy", column = "modified_by"),
            @Result(property = "deleteFlag", column = "delete_flag") })
    List<Server> getServer();
}



/*[
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
 },
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
 }
]*/