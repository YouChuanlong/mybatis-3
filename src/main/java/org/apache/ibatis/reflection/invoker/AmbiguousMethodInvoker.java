/*
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.ibatis.reflection.ReflectionException;

/**
 * 不明确的方法调用，这个类实际上没有什么功能，就是异常处理
 * 这个类只有在 Reflector 类中有调用的
 */
public class AmbiguousMethodInvoker extends MethodInvoker {
  private final String exceptionMessage;

  // 只有带参构造传递方法对象以及异常信息
  public AmbiguousMethodInvoker(Method method, String exceptionMessage) {
    super(method);
    this.exceptionMessage = exceptionMessage;
  }

  @Override
  public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
    // 调用就会抛异常的哈！
    // 这个异常是MyBatis自己定义的一个运行时异常
    throw new ReflectionException(exceptionMessage);
  }
}
