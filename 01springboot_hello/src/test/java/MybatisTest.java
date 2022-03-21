import com.zr.Application;
import com.zr.entity.Account;
import com.zr.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // springboot 启动类
@SpringBootTest(classes = Application.class) // 设置启动类
public class MybatisTest {

    @Autowired
    private AccountService accountService;


    @Test
    public void test(){
        Account account = Account.builder().name("gg").balance(500).build();
        int rows = accountService.insertAccount(account);
        System.out.println(rows==1?"添加成功":"添加失败");
    }
}
