package com.zst.el.service.impl;

import com.zst.el.dao.EmUserInfoMapper;
import com.zst.el.dao.EmUserMapper;
import com.zst.el.dao.EmUserMessageMapper;
import com.zst.el.dao.EmUserPasswordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author robert
 * @date 2021/5/10 15:22
 */
@Service
public class BaseService {

    @Autowired
    protected EmUserMapper emUserMapper;

    @Autowired
    protected EmUserInfoMapper emUserInfoMapper;

    @Autowired
    protected EmUserMessageMapper userMessageMapper;

    @Autowired
    protected EmUserPasswordMapper passwordMapper;
}
