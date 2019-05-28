package com.onlineshop.shop.repositories;

import com.onlineshop.shop.model.ClientOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<ClientOrder, Integer> {

    List<ClientOrder> findAllByUserId(int id);
}
