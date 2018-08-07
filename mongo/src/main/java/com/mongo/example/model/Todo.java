package com.mongo.example.model;

import org.springframework.data.annotation.Id;

public final class Todo {

	static final int MAX_LENGTH_DESCRIPTION = 500;
	static final int MAX_LENGTH_TITLE = 100;

	@Id
	private String id;

	public String getId() {
		return id;
	}

	private String description;

	public String getDescription() {
		return description;
	}

	private String title;

	public String getTitle() {
		return title;
	}

	public Todo() {}

	private Todo(Builder builder) {
		this.description = builder.description;
		this.title = builder.title;
	}

	public static Builder getBuilder() {
		return new Builder();
	}


	public static class Builder {

		private String description;

		private String title;

		private Builder() {}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Todo build() {
			final Todo build = new Todo(this);

			return build;
		}
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
