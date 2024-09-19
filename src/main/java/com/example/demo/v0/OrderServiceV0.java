
package com.example.demo.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRepositoryV0 repository;

    public void save(String itemId) {
        repository.save(itemId);
    }
}
