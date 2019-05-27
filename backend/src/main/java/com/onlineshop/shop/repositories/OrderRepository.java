package com.onlineshop.shop.repositories;

import com.onlineshop.shop.model.ClientOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<ClientOrder, Integer> {
}
