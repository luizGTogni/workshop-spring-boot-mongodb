package com.toogni.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toogni.workshopmongo.entities.Post;
import com.toogni.workshopmongo.repositories.PostRepository;
import com.toogni.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
}
