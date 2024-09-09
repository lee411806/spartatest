package com.sparta.spratatest.repository;

import com.sparta.spratatest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface postRepository extends JpaRepository<Item,Long> {
}
