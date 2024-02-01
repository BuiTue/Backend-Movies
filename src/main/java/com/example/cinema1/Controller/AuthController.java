package com.example.cinema1.Controller;

import com.example.cinema1.Config.Exception.CustomException;
import com.example.cinema1.Config.Exception.ErrorResponseEnum;
import com.example.cinema1.Modal.Dto.LoginDto;
import com.example.cinema1.Modal.Dto.UserCreateDto;
import com.example.cinema1.Modal.Entity.Role;
import com.example.cinema1.Modal.Entity.TokenActiveUser;
import com.example.cinema1.Modal.Entity.User;
import com.example.cinema1.Responsitory.TokenRepository;
import com.example.cinema1.Responsitory.UserRepository;
import com.example.cinema1.Service.JWTTokenUtils;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/auth")
@CrossOrigin(value = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private JWTTokenUtils jwtTokenUtils;


    @PostMapping("/login-jwt")
    public LoginDto loginJWT(@RequestParam String username, @RequestParam String password){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // Check usernam & password: nếu đúng -> trả về token và các thông tin khác
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new CustomException(ErrorResponseEnum.LOGIN_FAIL_USERNAME);
        }
        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new CustomException(ErrorResponseEnum.LOGIN_FAIL_PASSWORD);
        }
        LoginDto loginDto = new LoginDto();
        BeanUtils.copyProperties(user, loginDto);
        String token = jwtTokenUtils.createAccessToken(loginDto);
        loginDto.setToken(token);
        return loginDto;
    }

    @GetMapping("/active/{token}")
    public String activeAccount(@PathVariable String token){
        TokenActiveUser activeUser = tokenRepository.findByToken(token);
        if (activeUser == null){
            return "Mã kích hoạt không tồn tại";
        }
        User user = activeUser.getUser();
        userRepository.save(user);
        return "Tài khoản đã được kích hoạt!";
    }


    @PostMapping("/register") // /api/v1/account/create
    public User create(@RequestBody @Valid UserCreateDto dto){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        BeanUtils.copyProperties(dto, user);

        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // Set password đã mã hoá vào DB

        user = userRepository.save(user); // Hứng giá trị của account khi thêm mới user( để lấy được giá trị id)

        // Tạo ra mã token để active account -> lưu trong bảng TokenActiveAccount
        String token = UUID.randomUUID().toString();
        TokenActiveUser tokenActiveUser = new TokenActiveUser();
        tokenActiveUser.setUser(user);
        tokenActiveUser.setToken(token);
        tokenRepository.save(tokenActiveUser);

        return user;
    }
}
