package com.hunsley.mongo.repo;

import com.hunsley.mongo.model.ColosseumSnacks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColosseumSnacksRepository extends MongoRepository<ColosseumSnacks, Long> {

}
