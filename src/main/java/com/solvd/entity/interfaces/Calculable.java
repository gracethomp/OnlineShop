package com.solvd.entity.interfaces;

import com.solvd.lambda.IGet;

public interface Calculable<T> {
    double calculateTotalPrice(IGet<T> summarize);
}
