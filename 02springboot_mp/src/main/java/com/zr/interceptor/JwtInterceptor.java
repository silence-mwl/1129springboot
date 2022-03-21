package com.zr.interceptor;

import com.zr.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: silence
 * @Email: 792245022@qq.com
 * @date: 2022/3/21 0021 16:41
 * @ClassName: JwtInterceptor
 * @Package: com.zr.interceptor
 * @Description:
 * @version: 1.0.0
 */

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        final String header = request.getHeader("authority");
        if (header != null && !handler.equals("")) {
            if (header.startsWith("Bearer ")) {
                // 得到token
                final String token = header.substring(7);
                // 对令牌进行验证
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = claims.get("roles", String.class);
                    if (roles != null && roles.equals("admin")) {
                        request.setAttribute("claims_admin", claims);
                    }
                    if (roles != null && roles.equals("user")) {
                        request.setAttribute("claims_user", claims);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("令牌不正确!");
                }
            }
        }
        return true;
    }
}


