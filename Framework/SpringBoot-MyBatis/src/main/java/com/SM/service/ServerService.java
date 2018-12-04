package com.SM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SM.dao.ext.ServerExtMapper;
import com.SM.entity.Server;

/**
 * ServerService.
 * 
 * @author Wangp
 *
 */
@Transactional
@Service
public class ServerService {

    @Autowired
    private ServerExtMapper serverExtMapper;

    /**
     * getServer
     */
    public List<Server> getServer() {
        List<Server> ServerList = serverExtMapper.getServer();
        return ServerList;
    }
}
