package com.mongo.example;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.example.model.Todo;
import com.mongo.example.service.TodoService;

@RestController
@RequestMapping("/api")
final class TodoController {

	private final TodoService service;

	@Autowired
	TodoController(TodoService service) {
		this.service = service;
	}

	@RequestMapping(value = "/todo",produces = { "application/json" }, method = RequestMethod.POST)
	Todo create(@RequestBody @Valid Todo todoEntry) {
		return service.create(todoEntry);
	}

	@RequestMapping(value = "/todo/{id}",produces = { "application/json" }, method = RequestMethod.DELETE)
	Todo delete(@PathVariable("id") String id) {
		return service.delete(id);
	}

	@RequestMapping(value = "/todo",produces = { "application/json" }, method = RequestMethod.GET)
	List<Todo> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/todo/{id}",produces = { "application/json" }, method = RequestMethod.GET)
	Todo findById(@PathVariable("id") String id) {
		final Optional<Todo>resp=service.findById(id);
		if (resp.isPresent()) {
			return resp.get();
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/todo/{id}",produces = { "application/json" }, method = RequestMethod.PUT)
	Todo update(@RequestBody @Valid Todo todoEntry) {
		return service.update(todoEntry);
	}

}
