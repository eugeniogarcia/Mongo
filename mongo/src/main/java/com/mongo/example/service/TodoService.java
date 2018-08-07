package com.mongo.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.example.model.Todo;
import com.mongo.example.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository repository;

	public Todo create(Todo todo) {
		final Todo persisted = Todo.getBuilder()
				.title(todo.getTitle())
				.description(todo.getDescription())
				.build();
		return repository.save(persisted);
	}

	public Todo delete(String id) {
		final Optional<Todo> deleted = findTodoById(id);
		if(deleted.isPresent()) {
			repository.delete(deleted.get());
			return deleted.get();
		}else {
			return null;
		}

	}

	public List<Todo> findAll() {
		return repository.findAll();
	}

	public Optional<Todo> findById(String id) {
		return findTodoById(id);

	}

	public Todo update(Todo todo) {
		final Optional<Todo> updated = findTodoById(todo.getId());
		if(updated.isPresent()) {
			updated.get().setDescription(todo.getDescription());
			updated.get().setTitle(todo.getTitle());
			return repository.save(updated.get());
		} else {
			return null;
		}
	}

	private Optional<Todo> findTodoById(String id) {
		return repository.findById(id);

	}

}
