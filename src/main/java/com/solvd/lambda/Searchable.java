package com.solvd.lambda;

@FunctionalInterface
public interface Searchable<T> {
    boolean search(T value);
}
