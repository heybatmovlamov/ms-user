package com.msuser.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorCode {

    public static final String ALREADY_EXIST = "already_exist";
    public static final String DATA_NOT_FOUND = "data_not_found";
}
