package de.chclaus.demo.vertx.rest;

import io.vertx.core.Vertx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author chclaus (ch.claus@me.com)
 */
@SpringBootApplication
public class DemoVertxRestApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoVertxRestApplication.class, args);
  }

  @Bean
  public Vertx vertx() {
    return Vertx.vertx();
  }

}
