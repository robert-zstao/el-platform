package com.zst.el.dao.impl;


import com.zst.el.dao.BaseDao;
import com.zst.el.dao.ISystemUserDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Repository
public class SystemUserDao extends BaseDao implements ISystemUserDao {

    private  static final String NAMESPACE = "com.zst.el.dao.SystemUserDao.";

//
//    @Override
//    public SystemUser selectUserById(String fdUserId) {
//        return this.getSqlSession().selectOne(NAMESPACE + "selectUserById", fdUserId);
//    }
//
//
//    @Override
//    public List<SystemUser> selectByCorp(SystemUser user, String fdCorpId,String userId, String userName, String userPhone) {
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("user",user);
//        params.put("userId",userId);
//        params.put("fdCorpId", user.getFdCorpId());
//        params.put("userName",userName);
//        params.put("userPhone",userPhone);
//        return this.getSqlSession().selectList(NAMESPACE + "selectByCorp", params);
//    }
//
//
//
//    @Override
//    public int insertSystemUser2(SystemUser user) {
//        return  this.getSqlSession().insert(NAMESPACE+"insertSystemUser2",user);
//    }
//
//
//    @Override
//    public int updateUserRole(String roleCode, String userCode) {
//        Map<String,Object> param = new HashMap<>();
//        param.put("roleCode",roleCode);
//        param.put("userCode",userCode);
//        return this.getSqlSession().update(NAMESPACE+"updateUserRole",param);
//    }
//
//    @Override
//    public int deleteUserRoleById(String userCode) {
//        return this.getSqlSession().delete(NAMESPACE+"deleteUserRoleById",userCode);
//    }




}
