package com.zst.el.dao;

import com.zst.el.bean.EmUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmUserMapper {

    int deleteByPrimaryKey(Integer sgId);

    int insert(EmUser record);

    int insertSelective(EmUser record);

    EmUser selectByPrimaryKey(Integer sgId);

    int updateByPrimaryKeySelective(EmUser record);

    int updateByPrimaryKey(EmUser record);
}