package example.micronaut.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    @Produces(MediaType.TEXT_PLAIN)
    @Get
    String index() {
        LOG.trace("inside hello world");
        return "Hello World";
    }
}
