package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.ZoneId;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return String.format("Greetings from Spring Boot! The current date-time is: '%s'.",
                Instant.now().atZone(ZoneId.of("America/Los_Angeles")).toString());
    }
}
