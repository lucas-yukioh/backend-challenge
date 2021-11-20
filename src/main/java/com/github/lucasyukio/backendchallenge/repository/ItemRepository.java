package com.github.lucasyukio.backendchallenge.repository;

import com.github.lucasyukio.backendchallenge.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
