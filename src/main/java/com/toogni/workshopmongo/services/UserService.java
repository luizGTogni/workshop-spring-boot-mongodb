package com.toogni.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toogni.workshopmongo.dto.UserDTO;
import com.toogni.workshopmongo.entities.User;
import com.toogni.workshopmongo.repositories.UserRepository;
import com.toogni.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public User update(User data) {
		User user = findById(data.getId());
		updateData(user, data);
		return repository.save(user);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	private void updateData(User user, User data) {
		user.setName(data.getName());
		user.setEmail(data.getEmail());
	}
}
