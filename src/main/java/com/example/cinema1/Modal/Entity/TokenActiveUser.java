package com.example.cinema1.Modal.Entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`TOKEN`")
@Getter
@Setter
@NoArgsConstructor  // Tạo ra hàm khởi tạo k tham số
@AllArgsConstructor // Tạo hàm khởi tạo có tham số

public class TokenActiveUser extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; // Fgkey tới bảng muốn active

    @Column(name = "token")
    private String token; // Đây là mã dùng để active tài khoản,
}
