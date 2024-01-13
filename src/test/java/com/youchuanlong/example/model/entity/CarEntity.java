package com.youchuanlong.example.model.entity;

import com.youchuanlong.example.model.entity.UserEntity;
import org.apache.ibatis.submitted.result_handler.UserResultHandler;

/**
 * @author Ryan You <br/> Created at 2024/1/11 20:57
 */
public class CarEntity {


    private Long id;
    /**
     * 车牌号
     */
    private String plate;

    /**
     * 车辆颜色
     */
    private String color;


    /**
     * 车主
     */
    private UserEntity owner;
}
