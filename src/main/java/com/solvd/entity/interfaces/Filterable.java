package com.solvd.entity.interfaces;

import com.solvd.entity.enums.ProductTypes;
import com.solvd.entity.goods.Product;

import java.util.List;

public interface Filterable {
    List<Product> filterByPrice(double priceFrom, double priceTo);
    List<Product> filterByType(ProductTypes type);
}
