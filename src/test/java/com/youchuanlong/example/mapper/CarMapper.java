package com.youchuanlong.example.mapper;

import com.youchuanlong.example.model.entity.CarEntity;
import java.util.List;

/**
 * @author Ryan You <br/> Created at 2024/1/11 21:03
 */
public interface CarMapper {

    /**
     * 根据用户id查询车辆信息
     * @param userId 用户id
     * @return 车辆信息
     */
    List<CarEntity> selectCarByUserId(Long userId);
}
