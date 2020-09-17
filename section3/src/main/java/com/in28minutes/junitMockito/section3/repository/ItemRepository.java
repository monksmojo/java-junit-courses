package com.in28minutes.junitMockito.section3.repository;

import com.in28minutes.junitMockito.section3.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
