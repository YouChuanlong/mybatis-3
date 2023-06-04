package org.apache.ibatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author YouChuanlong
 * Created at 2023/5/30 08:45
 */

public class MyPluginTest {

  private final static Logger LOGGER = LoggerFactory.getLogger(MyPluginTest.class);



  @Test
  public void testCustomizePlugin() throws NoSuchFieldException, IllegalAccessException {
      Person person = new Person();
      Field field = person.getClass().getDeclaredField("sql");
      field.setAccessible(true);
      field.set(person,"SELECT COUNT(2)");
    System.out.println(person.sql);


  }


  static class Person{
    private final String sql = "select count(1)";
  }




}
