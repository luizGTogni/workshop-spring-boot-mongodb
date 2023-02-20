package com.toogni.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.toogni.workshopmongo.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
