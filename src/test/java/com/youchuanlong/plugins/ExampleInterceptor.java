package com.youchuanlong.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author YouChuanlong
 * Created at 2023/6/3 23:55
 */

@Intercepts(
  @Signature(
      type = Executor.class,
      method = "query" ,
      args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
)
public class ExampleInterceptor implements Interceptor {
  Log log = LogFactory.getLog(ExampleInterceptor.class);
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    Object[] args = invocation.getArgs();
    MappedStatement ms = (MappedStatement)args[0];
    Object param = args[1];
    BoundSql boundSql = ms.getBoundSql(param);
    String sql = boundSql.getSql();
    boundSql.setAdditionalParameter("db","test");
    System.err.println(sql);
    return invocation.proceed();
  }

  @Override
  public void setProperties(Properties properties) {
    Interceptor.super.setProperties(properties);
  }
}
