package com.minjeong.usedPhone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {
    private T data;
    private String message;
    private String code;

    public static <T> ResponseWrapper<T> success(T data, String message, String code) {
        return new ResponseWrapper<>(data, message, code);
    }

    public static <T> ResponseWrapper<T> success(String message, String code) {
        return new ResponseWrapper<>(null, message, code);
    }
}
