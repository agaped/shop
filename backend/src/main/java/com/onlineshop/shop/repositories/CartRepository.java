package com.onlineshop.shop.repositories;

import com.onlineshop.shop.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
