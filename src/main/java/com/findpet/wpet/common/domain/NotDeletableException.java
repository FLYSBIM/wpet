package com.findpet.wpet.common.domain;

public class NotDeletableException extends RuntimeException {

    private static final String NOT_DELETABLE = "이미 삭제한 데이터는 삭제할 수 없습니다.";

    public NotDeletableException() {
        super(NOT_DELETABLE);
    }
}
