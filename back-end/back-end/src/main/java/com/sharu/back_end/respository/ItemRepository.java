package com.sharu.back_end.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sharu.back_end.model.Item;

public interface ItemRepository extends MongoRepository<Item, String> {
    
}
