package com.zst.el.service.impl;

import com.zst.el.bean.EmUser;
import com.zst.el.bean.EmUserInfo;
import com.zst.el.service.IEmUserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author robert
 * @date 2021/5/10 15:20
 */
@Service
public class EmUserInfoService extends BaseService implements IEmUserInfoService {

    @Override
    public int addInfo(EmUserInfo emUserInfo) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(EmUserInfo emUserInfo) {
        return 0;
    }

    @Override
    public EmUserInfo findOne(String id) {
        return null;
    }

    @Override
    public EmUserInfo queryById(EmUserInfo emUserInfo) {
        return null;
    }

    @Override
    public List<EmUserInfo> queryByList(EmUser user, EmUserInfo emUserInfo) {
        return null;
    }
}
