package com.youchuanlong.test;

import com.youchuanlong.example.mapper.CarMapper;
import com.youchuanlong.example.model.entity.CarEntity;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Ryan You <br/> Created at 2024/1/11 21:17
 */
public class CarMapperTest extends BaseMyBatisTest {

    @Test
    public void testSelectCarByUserId() {

        try ( SqlSession sqlSession = sqlSessionFactory.openSession())  {
            CarMapper mapper = sqlSession.getMapper(CarMapper.class);
            List<CarEntity> cars = mapper.selectCarByUserId(1L);
            assertNotNull(cars);
            assertEquals(2, cars.size());
        }
    }

}
