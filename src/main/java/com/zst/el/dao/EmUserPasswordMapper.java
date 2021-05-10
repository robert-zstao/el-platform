package com.zst.el.dao;

import com.zst.el.bean.EmUserPassword;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmUserPasswordMapper {

    int deleteByPrimaryKey(Integer sgId);

    int insert(EmUserPassword record);

    int insertSelective(EmUserPassword record);

    EmUserPassword selectByPrimaryKey(Integer sgId);

    int updateByPrimaryKeySelective(EmUserPassword record);

    int updateByPrimaryKey(EmUserPassword record);
}