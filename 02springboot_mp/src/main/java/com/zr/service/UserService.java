package com.zr.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zr.dao.UserDao;
import com.zr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author: silence
 * @Email: 792245022@qq.com
 * @date: 2022/3/18 0018 11:11
 * @ClassName: UserService
 * @Package: com.zr.service
 * @Description:
 * @version: 1.0.0
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @param current 当前页
     * @param size    每页显示数
     * @return
     */
    public IPage<User> queryPage(int current, int size, User user) {
        QueryWrapper qw = new QueryWrapper();
        qw.like(!StringUtils.isEmpty(user.getName()), "name", user.getName());
        qw.like(!StringUtils.isEmpty(user.getEmail()), "email", user.getEmail());
        qw.orderByDesc("create_time");
        Page<User> page = new Page<>(current, size);
        return userDao.selectPage(page, qw);
    }

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user) {
        userDao.insert(user);
    }

    /**
     * 查询用户根据id
     * @param id
     * @return
     */
    public User findUserById(long id) {
        return userDao.selectById(id);
    }

    public void updateUser(User user) {
        userDao.updateById(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
