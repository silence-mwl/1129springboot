package com.zr.service;

import com.zr.dao.AdminDao;
import com.zr.entity.Admin;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: silence
 * @Email: 792245022@qq.com
 * @date: 2022/3/21 0021 14:52
 * @ClassName: AdminService
 * @Package: com.zr.service
 * @Description:
 * @version: 1.0.0
 */
@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminDao adminDao;

    public void addAdmin(Admin admin) {
        String pwd = BCrypt.hashpw(admin.getPwd(), BCrypt.gensalt());// 加密
        admin.setPwd(pwd);
        adminDao.insert(admin);
    }

    /**
     * 判断用户名密码是否正确
     * @param username
     * @param pwd
     * @return
     */
    public Admin loginUsernameAndPwd(String username, String pwd) {
        Admin admin = adminDao.loginUsernameAndPwd(username);
        if (admin != null) {
            // 判断密码是否正确
            return BCrypt.checkpw(pwd, admin.getPwd()) ? admin : null;
        }
        return null; // 用户名错误
    }
}
