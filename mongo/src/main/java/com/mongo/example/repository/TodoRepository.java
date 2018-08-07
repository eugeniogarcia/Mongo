package com.mongo.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.example.model.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
	public void delete(Todo deleted);
	public List<Todo> findAll();
	public Optional<Todo> findById(String id);
	public Todo save(Todo saved);
}