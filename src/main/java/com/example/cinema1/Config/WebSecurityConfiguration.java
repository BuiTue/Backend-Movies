package com.example.cinema1.Config;

import com.example.cinema1.Service.UserService;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPrivateKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // kết hợp với @Bean để tạo thành 1 bean trong spring IOC
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Để có thể phân quyền tại controller
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserService userService;



    @Autowired
    private JwtRequestFilter jwtRequestFilter;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userService).// Cấu hình UserDetailsService để khi xác thực người dùng sẽ gọi tới hàm loadUserByUsername()
                passwordEncoder(passwordEncoder);// Cấu hình phương thức để mã hoá mật khẩu
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // config những API ko cần xác thực
                .antMatchers("api/not-authenticated", "/api/v1/user/create", "/api/v1/movie/get-all",
                        "/api/v1/schedule/get-all", "/api/v1/movie/findById",
                        "/api/v1/auth/login-jwt", "/api/v1/auth/**","/api/v1/cinema/get-all").permitAll()

                // Config những API phải có Authority là ADMIN thì mới được truy cập
                .antMatchers(HttpMethod.GET,"/api/v1/user/get-by-role","/api/v1/ticket/**","/api/v1/ticket/**",
                        "/api/v1/movie/**","/api/v1/user/**","/api/v1/cinema/**","/api/v1/schedule/**" ).hasAuthority("ADMIN")

                .antMatchers(HttpMethod.POST,"/api/v1/movie/**",
                        "/api/v1/user/**","/api/v1/cinema/**","/api/v1/schedule/**" ).hasAuthority("ADMIN")

                .antMatchers(HttpMethod.PUT,"/api/v1/ticket/**","/api/v1/movie/**",
                        "/api/v1/user/**","/api/v1/cinema/**","/api/v1/schedule/**" ).hasAuthority("ADMIN")

                .antMatchers(HttpMethod.DELETE,"/api/v1/user/get-by-role",
                        "/api/v1/movie/updateMovie","/api/v1/user/**" ).hasAuthority("ADMIN")

                // Config những API phải có Authority là ADMIN hoặc User thì mới được truy cập
                .antMatchers("api/admin-or-user").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST,"api/v1/ticket/create","api/v1/ticket/createList").hasAnyAuthority("ADMIN", "USER")



                .anyRequest().authenticated()// Những đường dẫn còn lại cần được xác thực
                .and().httpBasic()// Kích hoạt cấu hình http basic trong Spring Security
                // tắt tính năng Cross-Site Request Forgery (CSRF) trong Spring Security.
                .and().cors().and().csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);// STATELESS và STATEFULL
        // Khai báo class filter sẽ thực hiện trước khi xác thực và phân quyền.
        // Và khai báo đối tượng dùng để authentication
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override // Config cho đường dẫn (swagger) ko bị chặn bởi security
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/swagger-ui/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/v3/api-docs/**");
    }
}

