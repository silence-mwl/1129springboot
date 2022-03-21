import com.zr.Application;
import com.zr.entity.Admin;
import com.zr.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: silence
 * @Email: 792245022@qq.com
 * @date: 2022/3/21 0021 15:04
 * @ClassName: AminTest
 * @Package: PACKAGE_NAME
 * @Description:
 * @version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AminTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void test() {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPwd("1234");
        admin.setRoles("admin");
        System.out.println(admin);
       adminService.addAdmin(admin);
    }
}
