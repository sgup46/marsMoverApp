package com.unifyed.service;

import java.util.List;

public interface MarsMoverService<T, R> {
    public R process(T inputs);
}
