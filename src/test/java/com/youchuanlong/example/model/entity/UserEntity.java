package com.youchuanlong.example.model.entity;

import java.util.List;

/**
 * @author YouChuanlong
 * Created at 2023/6/3 23:39
 */
public class UserEntity {
  private Long id;

  private String username;

  private List<CarEntity> cars;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<CarEntity> getCars() {
    return cars;
  }

  public void setCars(List<CarEntity> cars) {
    this.cars = cars;
  }
}
