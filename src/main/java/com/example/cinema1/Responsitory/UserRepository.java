package com.example.cinema1.Responsitory;

import com.example.cinema1.Modal.Entity.Role;
import com.example.cinema1.Modal.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

    boolean existsByUsername(String username);

    List<User> findByUsernameAndAddressAndRole(String username, String Address, Role role);

    List<User> findByAddressAndRole(String Address, Role role);

    List<User> findByUsernameContains(String username);

    List<User> findByUsernameLike(String username);
//    List<User> findByRole(List<Role> roles);


    @Query(value = "select * from Account ac where ac.username = :username", nativeQuery = true)
    List<User> findByUsername2(String username);

}
