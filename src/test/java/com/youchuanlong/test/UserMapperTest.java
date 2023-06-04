package com.youchuanlong.test;

import com.youchuanlong.example.mapper.UserMapper;
import com.youchuanlong.example.model.entity.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * @author YouChuanlong
 * Created at 2023/6/3 23:42
 */
public class UserMapperTest extends BaseMyBatisTest{

  @Test
  public void testSelectUserAll(){
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    List<UserEntity> list = mapper.selectUserAll();
    assertNotNull(list);
    assertEquals(4,list.size());
  }
}
