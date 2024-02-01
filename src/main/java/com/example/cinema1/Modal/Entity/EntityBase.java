package com.example.cinema1.Modal.Entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class EntityBase {

    @Column(name = "CREATE_BY")
    protected String createBy;

    @Column(name = "CREATE_AT")
    protected Date createAt;

    @Column(name = "UPDATE_BY")
    protected String updateBy;

    @Column(name = "UPDATE_AT")
    protected Date updateAt;

    @PrePersist
    public void prePersist(){
        this.createAt = new Date();
        try {
            this.createBy = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception ex){
            this.createBy = "User chưa đăng nhập";
        }
    }

    @PreUpdate
    public void preUpdate(){
        try {
            this.updateBy = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception ex){
            this.updateBy = "User chưa đăng nhập";
        }
        this.updateAt = new Date();
    }

}
