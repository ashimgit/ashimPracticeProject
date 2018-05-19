package com.pojo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Student implements Serializable{
	@Id
	String id;
	
	String name;
	String friend_name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFriend_name() {
		return friend_name;
	}
	public void setFriend_name(String friend_name) {
		this.friend_name = friend_name;
	}
	
	

}
