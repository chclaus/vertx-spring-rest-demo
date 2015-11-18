package de.chclaus.demo.vertx.rest;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chclaus (ch.claus@me.com)
 */
@Component
public class Server {

  @Value("${vertx.server.serverPort}")
  private int serverPort;

  @Autowired
  private Vertx vertx;

  @Autowired
  private Router staticRouter;

  @Autowired
  private Router demoRouter;

  @Bean
  public Router mainRouter() {
    return Router.router(vertx);
  }

  @PostConstruct
  public void init() {
    Router mainRouter = mainRouter();

    mainRouter.mountSubRouter("/static/", staticRouter);
    mainRouter.mountSubRouter("/api", demoRouter);

    vertx.createHttpServer().requestHandler(mainRouter::accept).listen(serverPort);
  }
}
