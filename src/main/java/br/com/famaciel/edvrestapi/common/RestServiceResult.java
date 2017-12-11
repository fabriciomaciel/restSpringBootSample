package br.com.famaciel.edvrestapi.common;

import java.util.ArrayList;
import java.util.List;

public class RestServiceResult {
	
	private Integer statusCode;
	
	private List<String> messages;

	
	/**
	 * @param statusCode
	 * @param messages
	 */
	public RestServiceResult(Integer statusCode, String msg) {
		super();
		this.statusCode = statusCode;
		this.messages = new ArrayList<String>();
		this.messages.add(msg);
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
