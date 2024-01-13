package com.youchuanlong.example.mapper;

import com.youchuanlong.example.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author YouChuanlong
 * Created at 2023/6/2 10:34
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有的用户
     * @return 用户列表
     */
    List<UserEntity> selectUserAll();


    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户
     */
    UserEntity selectById(Long id);

    /**
     * 根据条件来查询用户
     * @param user 用户
     * @return 用户列表
     */
    List<UserEntity> selectUserList(@Param("user") UserEntity user);

    /**
     * 查询用户和车辆信息
     * @return 用户和车辆信息
     */
    List<UserEntity> selectUserAndCars();
}
