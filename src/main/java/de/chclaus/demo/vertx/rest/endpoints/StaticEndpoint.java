package de.chclaus.demo.vertx.rest.endpoints;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author chclaus (ch.claus@me.com)
 */
@Component
public class StaticEndpoint {

  @Autowired
  private Vertx vertx;

  @Bean(name = "staticRouter")
  public Router staticRouter() {
    Router router = Router.router(vertx);
    router.route().handler(StaticHandler.create());

    return router;
  }
}
