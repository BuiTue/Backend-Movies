package com.example.cinema1.Responsitory.Specification;

import com.example.cinema1.Modal.Dto.SearchUserRequest;
import com.example.cinema1.Modal.Entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> buildCondition(SearchUserRequest request){
        return Specification.where(findByUsername(request))
                .and(findByPhoneNumber(request))
                .and(findByEmail(request))
                .and(findByRole(request));
    }


    private static Specification<User> findByUsername(SearchUserRequest request) {
        if (request.getUsername() != null) {
            return (root, query, cri) -> {
                return cri.like(root.get("name"), "%" + request.getUsername() + "%");
            };
        } else {
            return null;
        }
    }

    private static Specification<User> findByPhoneNumber(SearchUserRequest request) {
        if (request.getPhoneNumber() != null) {
            return (root, query, cri) -> {
                return cri.like(root.get("name"), "%" + request.getPhoneNumber() + "%");
            };
        } else {
            return null;
        }
    }

    private static Specification<User> findByEmail(SearchUserRequest request) {
        if (request.getEmail() != null) {
            return (root, query, cri) -> {
                return cri.like(root.get("name"), "%" + request.getEmail() + "%");
            };
        } else {
            return null;
        }
    }

    private static Specification<User> findByRole(SearchUserRequest request) {
        if (request.getRole() != null) {
            return (root, query, cri) -> {
                return cri.equal(root.get("role"), request.getRole());
            };
        } else {
            return null;
        }
    }


}
