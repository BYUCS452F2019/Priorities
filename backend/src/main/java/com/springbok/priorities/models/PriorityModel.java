package com.springbok.priorities.models;

public class PriorityModel {
  @DBTable(columnName = "priority_id")
  public Integer priority_id;
  @DBTable(columnName = "user_id")
  public Integer user_id;
  @DBTable(columnName = "title")
  public String title;
  @DBTable(columnName = "type")
  public String type;
  @DBTable(columnName = "number")
  public Integer number;

  public Integer getPriority_id() {
    return priority_id;
  }

  public void setPriority_id(Integer priority_id) {
    this.priority_id = priority_id;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public PriorityModel(Integer priority_id, Integer user_id, String title, String type, Integer number) {
    this.priority_id = priority_id;
    this.user_id = user_id;
    this.title = title;
    this.type = type;
    this.number = number;
  }
}