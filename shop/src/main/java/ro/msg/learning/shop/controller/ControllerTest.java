package ro.msg.learning.shop.controller;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile(value = "test")
public class ControllerTest {
    Flyway flyway = Flyway.configure().dataSource("jdbc:h2:mem:~/testH2", "sa", "password").load();

    @PostMapping("test/load")
    public void load(){
        flyway.migrate();
    }

    @PostMapping("test/clear")
    public void clear(){
        flyway.clean();
    }
}
