package de.chclaus.demo.vertx.rest.service;

import org.springframework.stereotype.Service;

/**
 * @author chclaus (ch.claus@me.com)
 */
@Service
public class DemoService {

  public Demo getDemo() {
    return new Demo("one", "two");
  }

  public static class Demo {
    private String foo;
    private String bar;

    public Demo(String foo, String bar) {
      this.foo = foo;
      this.bar = bar;
    }

    public String getFoo() {
      return foo;
    }

    public String getBar() {
      return bar;
    }
  }
}
