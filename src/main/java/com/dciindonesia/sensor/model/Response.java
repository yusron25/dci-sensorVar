package com.dciindonesia.sensor.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Response<T> {
	private Boolean success;
	private String message;
	private List<T> data;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
