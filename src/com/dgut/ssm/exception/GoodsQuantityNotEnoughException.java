package com.dgut.ssm.exception;

public class GoodsQuantityNotEnoughException extends RuntimeException {
    public GoodsQuantityNotEnoughException(String message) {
        super(message);
    }
}
