package com.fernandoschimidt.dasafioBTG.reposioty;

import com.fernandoschimidt.dasafioBTG.controller.dto.OrderResponse;
import com.fernandoschimidt.dasafioBTG.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderReposioty extends MongoRepository<OrderEntity, Long> {
    Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest);
}