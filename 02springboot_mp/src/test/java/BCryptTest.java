import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author: silence
 * @Email: 792245022@qq.com
 * @date: 2022/3/21 0021 11:17
 * @ClassName: BCryptTest
 * @Package: PACKAGE_NAME
 * @Description:
 * @version: 1.0.0
 */
public class BCryptTest {

    @Test
    public void test() {
        String hashpw = BCrypt.hashpw("1234", BCrypt.gensalt());
        System.out.println("hashpw = " + hashpw);
    }

    @Test
    public void test1() {
        boolean flag = BCrypt.checkpw("1234", "$2a$10$2K16kDR/BCZ3mPqVcOCFRu6maB2QBa0MR84DMcgVfZuxTvsoRJmH.");
        System.out.println("flag = " + flag);

    }
}
