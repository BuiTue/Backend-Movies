package com.example.cinema1.Config.Exception;

public enum ErrorResponseEnum {

    NOT_FOUND_PRODUCT(404, "Không tìm thấy sản phẩm"),
    NOT_FOUND_ACCOUNT(404, "Không tìm thấy người dùng"),
    USERNAME_EXISTED(400, "Username đã tồn tại!"),
    LOGIN_FAIL_NOT_ACTIVE(401, "Tài khoản chưa được kích hoạt, kiểm tra mail để kích hoạt tài khoản!"),
    LOGIN_FAIL_USERNAME(401, "THông tin username sai!"),
    LOGIN_FAIL_PASSWORD(401, "THông tin Password sai!");

    public final int status;
    public final String message;

    ErrorResponseEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
