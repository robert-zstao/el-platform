package com.zst.el.dao;

import com.zst.el.bean.EmUserMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface EmUserMessageMapper {

    int deleteByPrimaryKey(Integer sgId);

    int insert(EmUserMessage record);

    int insertSelective(EmUserMessage record);

    EmUserMessage selectByPrimaryKey(Integer sgId);

    int updateByPrimaryKeySelective(EmUserMessage record);

    int updateByPrimaryKey(EmUserMessage record);
}