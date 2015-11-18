package de.chclaus.demo.vertx.rest.endpoints;

import de.chclaus.demo.vertx.rest.service.DemoService;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author chclaus (ch.claus@me.com)
 */
@Component
public class DemoEndpoint {

  @Autowired
  private Vertx vertx;

  @Autowired
  private DemoService demoService;

  /**
   * Defines the router for the api endpoints.
   * @return the router for the api endpoints.
   */
  @Bean(name = "demoRouter")
  public Router demoRouter() {
    Router demoRouter = Router.router(vertx);

    demoRouter.route().handler(this::decorate);
    demoRouter.route("/foo").handler(this::foo);

    return demoRouter;
  }

  /**
   * All routes shall return the content-type application/json.
   *
   * @param routingContext
   */
  private void decorate(RoutingContext routingContext) {
    routingContext.response().putHeader("content-type", "application/json; charset=utf-8");
    routingContext.next();
  }

  private void foo(RoutingContext routingContext) {
    routingContext.response().end(Json.encode(demoService.getDemo()));
  }
}
