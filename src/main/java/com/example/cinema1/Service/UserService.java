package com.example.cinema1.Service;

import com.example.cinema1.Config.Exception.CustomException;
import com.example.cinema1.Config.Exception.ErrorResponseEnum;
import com.example.cinema1.Modal.Dto.BaseRequest;
import com.example.cinema1.Modal.Dto.SearchUserRequest;
import com.example.cinema1.Modal.Dto.UserCreateDto;
import com.example.cinema1.Modal.Dto.UserUpdateDto;
import com.example.cinema1.Modal.Entity.Role;
import com.example.cinema1.Modal.Entity.User;
import com.example.cinema1.Responsitory.Specification.UserSpecification;
import com.example.cinema1.Responsitory.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new CustomException(ErrorResponseEnum.NOT_FOUND_ACCOUNT);
        }
        return userOptional.get();
    }


    @Override
    public Page<User> search(SearchUserRequest request) {
        BaseRequest.verify(request);
        Specification<User> condition = UserSpecification.buildCondition(request);
        PageRequest pageRequest = BaseRequest.buildPageRequest(request);
        return userRepository.findAll(condition, pageRequest);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllByAdmin() {
        List<User> users = userRepository.findAll();
        List<User> usersByRole = new ArrayList<>();
        for (User u : users) {
            if (u.getRole().equals(Role.USER) )
                usersByRole.add(u);
        }
        return usersByRole;
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User create(UserCreateDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new CustomException(ErrorResponseEnum.USERNAME_EXISTED);
        }
        User user = new User();

        BeanUtils.copyProperties(dto, user);
        user.setRole(Role.USER);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id không tồn tại");
        }

    }

    @Override
    public User update(UserUpdateDto dto) {
        User user = getById(dto.getId());
        BeanUtils.copyProperties(dto, user);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username không tồn tại!");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getRole());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
