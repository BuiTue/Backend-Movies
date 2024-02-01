package com.example.cinema1.Config;

import com.example.cinema1.Modal.Dto.LoginDto;
import com.example.cinema1.Service.JWTTokenUtils;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION = "Authorization";


    @Autowired
    private JWTTokenUtils jwtTokenUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        // Lấy token từ api (request)
        String token = httpServletRequest.getHeader(AUTHORIZATION);
        String request = httpServletRequest.getRequestURI();
        if (StringUtils.containsAnyIgnoreCase(request, "/api/v1/auth/login-jwt")
                || StringUtils.containsAnyIgnoreCase(request, "/api/v1/user/create")
//                || StringUtils.containsAnyIgnoreCase(request, "/api/v1/user/get-all")
                || StringUtils.containsAnyIgnoreCase(request, "/api/v1/schedule/get-all")
                || StringUtils.containsAnyIgnoreCase(request, "/api/v1/cinema/get-all")
//                || StringUtils.containsAnyIgnoreCase(request, "/api/v1/ticket/get-all")
                || StringUtils.containsAnyIgnoreCase(request, "/api/v1/movie/get-all")
                || StringUtils.containsAnyIgnoreCase(request, "/api/v1/movie/findById")
                || StringUtils.containsAnyIgnoreCase(request, "/api/v1/auth/")
                || StringUtils.containsAnyIgnoreCase(request, "/swagger-ui")
                || StringUtils.containsAnyIgnoreCase(request, "/swagger-resources")
                || StringUtils.containsAnyIgnoreCase(request, "/v3/api-docs")) {
            // Những api public ko cần check token -> doFilter
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            // Kiểm tra token & Giải mã token -> lấy thông tin user -> authen
            LoginDto loginDto = jwtTokenUtils.checkToken(token, httpServletResponse, httpServletRequest);
            if (loginDto != null){
                // Lấy danh sách quyền của user
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(loginDto.getRole());
                // Tạo đối tượng để Authen vào hệ thống
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(), null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        }
    }

}
