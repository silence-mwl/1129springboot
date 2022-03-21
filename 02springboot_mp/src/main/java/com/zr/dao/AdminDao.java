package com.zr.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zr.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends BaseMapper<Admin> {

    @Select("select * from t_admin where username = #{username}")
    Admin loginUsernameAndPwd(@Param("username") String username); // 如果参数大于一个，需要通过@param进行指定
}