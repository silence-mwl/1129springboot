import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

/**
 * @author: silence
 * @Email: 792245022@qq.com
 * @date: 2022/3/21 0021 13:46
 * @ClassName: JwtTest
 * @Package: PACKAGE_NAME
 * @Description:
 * @version: 1.0.0
 */
public class JwtTest {

    @Test
    public void test() {
        // 生成token
        long start = System.currentTimeMillis();
        long exp = start + 1000 * 60;
        JwtBuilder builder = Jwts.builder().
                setId("10").
                setSubject("成龙").
                setIssuedAt(new Date()).
                signWith(SignatureAlgorithm.HS256, "zrkj").
                setExpiration(new Date(exp)).
                claim("roles","admin");// 自定义信息
        String token = builder.compact();
        System.out.println("token = " + token);
        // eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMCIsInN1YiI6IuaIkOm-mSIsImlhdCI6MTY0Nzg0MTc5M30.7zw5fhUxJ_hTJ8lb02J4FOrju_zoUMX8jU2-CZM6-SM
    }

    @Test
    public void test1() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMCIsInN1YiI6IuaIkOm-mSIsImlhdCI6MTY0Nzg0MzE2NSwiZXhwIjoxNjQ3ODQzMjI1LCJyb2xlcyI6ImFkbWluIn0.pvAcYWphmV9dORaxS02gyRq4iYZRvy5JbuQxoJmFFXI";
        Claims claims = (Claims) Jwts.parser().setSigningKey("zrkj").parse(token).getBody();
        System.out.println("claims.getId() = " + claims.getId());
        System.out.println("claims.getSubject() = " + claims.getSubject());
        System.out.println("claims.getIssuedAt() = " + claims.getIssuedAt());
        String roles = (String) claims.get("roles");
        System.out.println("roles = " + roles);
    }
}
