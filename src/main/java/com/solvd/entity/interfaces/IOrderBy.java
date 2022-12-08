package com.solvd.entity.interfaces;

import com.solvd.entity.goods.Product;

import java.util.List;

public interface IOrderBy {
    List<Product> orderByPrice();

    List<Product> orderByTitle();
}
