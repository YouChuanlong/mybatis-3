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
package org.apache.ibatis.plugin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class PluginTest {

  @Test
  void mapPluginShouldInterceptGet() {
    Map map = new HashMap();
    // int oldIdentityHashCode = System.identityHashCode(map);
    map = (Map) new AlwaysMapPlugin().plugin(map);
    int proxyObjIdentityHashCode = System.identityHashCode(map);
    assertEquals("Always", map.get("Anything"));
    // assertNotEquals(oldIdentityHashCode,proxyObjIdentityHashCode);

    // System.identityHashCode(obj):
    // Returns the same hash code for the given object as would be returned by the default method hashCode(),
    // whether or not the given object's class overrides hashCode(). The hash code for the null reference is zero.
  }

  @Test
  void shouldNotInterceptToString() {
    Map map = new HashMap();
    map = (Map) new AlwaysMapPlugin().plugin(map);
    assertNotEquals("Always", map.toString());
  }

  @Intercepts({
      @Signature(type = Map.class, method = "get", args = {Object.class})})
  public static class AlwaysMapPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) {
      return "Always";
    }

  }

}
