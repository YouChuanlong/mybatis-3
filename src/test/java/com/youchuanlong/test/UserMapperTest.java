package com.youchuanlong.test;

import com.youchuanlong.example.mapper.UserMapper;
import com.youchuanlong.example.model.entity.CarEntity;
import com.youchuanlong.example.model.entity.UserEntity;
import java.io.IOException;
import java.io.Reader;
import javax.sql.DataSource;
import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * @author YouChuanlong Created at 2023/6/3 23:42
 * @see UserEntity
 * @see UserMapper
 */
public class UserMapperTest extends BaseMyBatisTest {



    @Test
    public void testSelectUserAll() throws IOException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserEntity> list = mapper.selectUserAll();
            assertNotNull(list);
            assertEquals(5, list.size());
        }
    }


    @Test
    public void testSelectById() throws IOException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserEntity user = mapper.selectById(1L);
            assertNotNull(user);
            assertEquals("RyanYou", user.getUsername());
        }
    }


    @Test
    public void testSelectUserList() throws IOException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserEntity user = new UserEntity();
            user.setUsername("RyanYou");
            List<UserEntity> list = mapper.selectUserList(user);
            assertNotNull(list);
            assertEquals(1, list.size());
        }
    }

    @Test
    public void testSelectUserAssociationCars() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserEntity> users = mapper.selectUserAndCars();
            assertNotNull(users);
            assertEquals(5, users.size());

            int[] userAssocCarCounts  = {2, 2, 2, 2, 1};
            for(int i = 0;i < users.size();i++) {
                UserEntity user = users.get(i);
                List<CarEntity> cars = user.getCars();
                assertNotNull(cars);
                assertEquals(userAssocCarCounts[i], cars.size());
            }
        }
    }


}
