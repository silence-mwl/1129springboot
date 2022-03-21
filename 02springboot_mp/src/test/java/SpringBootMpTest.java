import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zr.Application;
import com.zr.dao.UserDao;
import com.zr.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootMpTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1() {
        List<User> userList = userDao.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void test2() {
        User user = User.builder().name("佳琪5").age(10).build();
        int rows = userDao.insert(user);
        System.out.println(rows == 1 ? "添加成功" : "添加失败");
    }

    @Test
    public void test3() {
        User user = userDao.selectById(1);
        user.setName("李连杰");
        user.setAge(15);
        int rows = userDao.updateById(user);
        System.out.println(rows == 1 ? "修改成功" : "修改失败");
    }

    @Test
    public void test4() { // 动态生成条件
        User user = new User();
        user.setName("张柏芝");
        user.setAge(20);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(true, User::getName, "Tom");
        int rows = userDao.update(user, wrapper);
        System.out.println(rows == 1 ? "修改成功" : "修改失败");
    }

    @Test
    public void test5() { // 动态生成条件和set语句
//        User user = new User();
//        user.setName("张柏芝");
//        user.setAge(20);
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
//        wrapper.setSql(true, "name = '谢霆锋'");
//        wrapper.setSql(true, "age = 30");
        wrapper.set(true, "name", "李梅");// == 动态sql <set>
        wrapper.eq(true, "name", "Sandy");
        int rows = userDao.update(null, wrapper);
        System.out.println(rows == 1 ? "修改成功" : "修改失败");
    }


    @Test
    public void test6() { // 动态生成条件和set语句
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(true, User::getName, "Sandy");
        wrapper.eq(true, User::getName, "李梅");// == 动态sql <set>
        int rows = userDao.update(null, wrapper);
        System.out.println(rows == 1 ? "修改成功" : "修改失败");
    }

    @Test
    public void test7() { // 动态生成条件和set语句
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.and(wp -> wp.eq(User::getAge, 20).like(User::getName, "张"));
        List<User> userList = userDao.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test8() { // 动态生成条件和set语句
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        wrapper.and(wp -> wp.eq(User::getAge, 10).or().like(User::getName, "张"));
        wrapper.nested(wp -> wp.eq(User::getAge, 10).or().like(User::getName, "张"));
        List<User> userList = userDao.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test9() { // 动态生成条件和set语句
        int rows = userDao.deleteById(1503993798940905473L);
        System.out.println(rows == 1 ? "删除成功" : "删除失败");
    }

    @Test
    public void test10() {
        Page<User> page = new Page<User>(1, 2);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(true, User::getId, 1);
        IPage<User> iPage = userDao.selectPage(page, wrapper);
        System.out.println("总条数：" + iPage.getTotal());
        System.out.println("结果集：");
        List<User> userList = iPage.getRecords();
        userList.forEach(System.out::println);
    }


}
