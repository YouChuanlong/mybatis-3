package com.youchuanlong.example.mapper;

import com.youchuanlong.example.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author YouChuanlong
 * Created at 2023/6/2 10:34
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<UserEntity> selectUserAll();
}
