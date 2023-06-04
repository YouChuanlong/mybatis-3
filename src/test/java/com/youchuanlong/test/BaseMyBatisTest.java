package com.youchuanlong.test;

import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;

import java.io.Reader;

/**
 * @author YouChuanlong
 * Created at 2023/6/3 23:42
 */
public class BaseMyBatisTest {

  protected static SqlSessionFactory sqlSessionFactory;




  @BeforeAll
  static void setUp() throws Exception {
    // create a SqlSessionFactory
    try (Reader reader = Resources.getResourceAsReader("com/youchuanlong/example/mybatis-config.xml")) {
      sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
    }

    // populate in-memory database
    BaseDataTest.runScript(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource(),
                           "com/youchuanlong/example/user_example.sql");
  }

}
