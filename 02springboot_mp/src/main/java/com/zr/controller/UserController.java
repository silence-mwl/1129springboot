package com.zr.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zr.entity.PageResult;
import com.zr.entity.Result;
import com.zr.entity.StatusCode;
import com.zr.entity.User;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: silence
 * @Email: 792245022@qq.com
 * @date: 2022/3/18 0018 9:35
 * @ClassName: UserController
 * @Package: com.zr.controller
 * @Description:
 * @version: 1.0.0
 */
@RestController
@CrossOrigin // 处理跨域
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("queryPage/{current}/{size}")
    public Result queryPage(@PathVariable int current, @PathVariable int size, @RequestBody User user) {
        IPage<User> iPage = userService.queryPage(current, size, user);

        // Claims claims = (Claims) request.getAttribute("admin_claims");
        // if (claims == null) {
        //     return new Result(true, StatusCode.ACCESSERROR, "无权访问");
        // }
        return new Result(true, StatusCode.OK, "查询成功",
                new PageResult<>(iPage.getTotal(), iPage.getRecords()));
    }


    @GetMapping("user/{id}")
    public Result user(@PathVariable Long id) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findUserById(id));
    }

    @PostMapping("adduser")
    public Result addUser(@RequestBody User user) {
        userService.addUser(user);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @PostMapping("updateuser")
    public Result updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @DeleteMapping("deleteuser/{id}")
    public Result deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
