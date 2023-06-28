package soloprojecttodo.global.exception;

import lombok.Getter;

public enum ExceptionCode {

    // 404 NOT FOUND 찾을 수 없음
    MEMBER_NOT_FOUND(404, "Member not found"),

    // 409 CONFLICT 중복된 리소스
    MEMBER_EXISTS(409, "Member exists");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
