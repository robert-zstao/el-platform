package com.zst.el.dao;

import com.zst.el.bean.EmUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmUserInfoMapper {

    int deleteByPrimaryKey(Integer sgId);

    int insert(EmUserInfo record);

    int insertSelective(EmUserInfo record);

    EmUserInfo selectByPrimaryKey(Integer sgId);

    int updateByPrimaryKeySelective(EmUserInfo record);

    int updateByPrimaryKey(EmUserInfo record);
}