package com.nhanshop.ecommerce.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Lỗi hệ thống không xác định.", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(9001, "Khóa cấu hình hoặc tham số không hợp lệ.", HttpStatus.BAD_REQUEST),
    DATABASE_ERROR(9002, "Lỗi tương tác cơ sở dữ liệu hệ thống.", HttpStatus.INTERNAL_SERVER_ERROR),

    UNAUTHORIZED(1001, "Yêu cầu đăng nhập để thực hiện thao tác này.", HttpStatus.UNAUTHORIZED),
    FORBIDDEN(1002, "Bạn không có quyền truy cập vào tính năng này.", HttpStatus.FORBIDDEN),
    INVALID_TOKEN(1003, "Mã Token bảo mật không hợp lệ hoặc đã bị thay đổi.", HttpStatus.UNAUTHORIZED),
    TOKEN_EXPIRED(1004, "Mã Token bảo mật đã hết hạn sử dụng.", HttpStatus.UNAUTHORIZED),
    INVALID_CREDENTIALS(1005, "Email hoặc mật khẩu đăng nhập không chính xác.", HttpStatus.UNAUTHORIZED),
    ACCOUNT_LOCKED(1006, "Tài khoản của bạn hiện đã bị khóa.", HttpStatus.FORBIDDEN),

    USER_EXISTED(2001, "Địa chỉ Email này đã được đăng ký trên hệ thống.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(2002, "Không tìm thấy người dùng trên hệ thống.", HttpStatus.NOT_FOUND),
    ROLE_NOT_FOUND(2003, "Không tìm thấy vai trò (Role) tương ứng trong DB.", HttpStatus.INTERNAL_SERVER_ERROR),

    PRODUCT_NOT_FOUND(3001, "Sản phẩm không tồn tại hoặc đã bị gỡ bỏ.", HttpStatus.NOT_FOUND),
    INSUFFICIENT_STOCK(3002, "Số lượng hàng trong kho không đủ đáp ứng.", HttpStatus.BAD_REQUEST),
    VOUCHER_INVALID(3003, "Mã giảm giá không hợp lệ.", HttpStatus.BAD_REQUEST),
    VOUCHER_EXPIRED(3004, "Mã giảm giá đã hết thời gian áp dụng.", HttpStatus.BAD_REQUEST),
    VOUCHER_LIMIT_EXCEEDED(3005, "Mã giảm giá đã vượt quá số lần sử dụng cho phép.", HttpStatus.BAD_REQUEST),
    ORDER_NOT_FOUND(3006, "Không tìm thấy thông tin đơn hàng.", HttpStatus.NOT_FOUND),
    INVALID_ORDER_STATE(3007, "Trạng thái đơn hàng không hợp lệ cho thao tác này.", HttpStatus.BAD_REQUEST),
    PAYMENT_FAILED(3008, "Thanh toán giao dịch trực tuyến thất bại.", HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
    ErrorCode(int code , String message , HttpStatus httpStatus){
        this.code = code;
        this.message = message;
        this.httpStatus=httpStatus;
    }
}
