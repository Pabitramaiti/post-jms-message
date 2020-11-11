package com.postjms.model;

public class JmsDetails {
	private String environment;
	private String name;
	private String username;
	private String password;
	private String content;
	private String queueOrTopic;
	private String errorMessage;

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQueueOrTopic() {
		return this.queueOrTopic;
	}

	public void setQueueOrTopic(String queueOrTopic) {
		this.queueOrTopic = queueOrTopic;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
