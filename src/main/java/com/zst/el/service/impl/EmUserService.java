package com.zst.el.service.impl;

import com.zst.el.bean.BaseBean;
import com.zst.el.bean.EmUser;
import com.zst.el.service.IEmUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author robert
 * @date 2021/5/10 15:25
 */
@Service
public class EmUserService extends BaseService implements IEmUserService {
    @Override
    public int addInfo(EmUser emUser) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(EmUser emUser) {
        return 0;
    }

    @Override
    public EmUser findOne(String id) {
        return null;
    }

    @Override
    public EmUser queryById(EmUser emUser) {
        return null;
    }

    @Override
    public List<EmUser> queryByList(EmUser user, EmUser emUser) {
        return null;
    }
}
