package com.zr.controller;

import com.zr.entity.Admin;
import com.zr.entity.Result;
import com.zr.entity.StatusCode;
import com.zr.service.AdminService;
import com.zr.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Email: 792245022@qq.com
 * @date: 2022/3/21 0021 14:54
 * @ClassName: AdminController
 * @Package: com.zr.controller
 * @Description:
 * @version: 1.0.0
 */

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("addAdmin")
    public Result addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @PostMapping("login")
    public Result login(@RequestBody Map<String, String> adminMap) {
        Admin admin =
                adminService.loginUsernameAndPwd(adminMap.get("username"), adminMap.get("pwd"));
        if (admin != null) {
            String token = "Bearer " + jwtUtil.createJWT(admin.getId() + "", admin.getUsername(), admin.getRoles());
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("token", token);
            resultMap.put("roles", admin.getRoles());
            resultMap.put("username", admin.getUsername());
            return new Result(true, StatusCode.OK, "登录成功", resultMap);
        } else {
            return new Result(false, StatusCode.ERROR, "用户名或密码错误");
        }
    }
}
