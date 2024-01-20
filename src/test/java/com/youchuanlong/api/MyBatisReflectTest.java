package com.youchuanlong.api;

import com.youchuanlong.example.model.entity.UserEntity;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 关于反射相关的 Test
 * @author Ryan You <br/> Created at 2024/1/16 14:30
 */
public class MyBatisReflectTest {


    @Test
    void testReflector() {
        final String fieldId = "id";
        final String fieldUsername = "username";
        ReflectorFactory factory = new DefaultReflectorFactory();
        Reflector reflector = factory.findForClass(UserEntity.class);
        Class<?> usernameType = reflector.getGetterType(fieldUsername);
        assertEquals(usernameType,String.class);

        Class<?> idType = reflector.getGetterType(fieldId);
        assertEquals(idType,Long.class);
    }
}
