package com.zr.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zr.entity.Admin;
import com.zr.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

// BaseMapper 可以生成单表的CRUD、批量添加、批量删除、分页
@Repository
public interface UserDao extends BaseMapper<User> {



}