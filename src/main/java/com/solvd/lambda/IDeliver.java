package com.solvd.lambda;

@FunctionalInterface
public interface IDeliver<T> {
    String deliver(String deliveryMessage, T itemToDeliver);
}
