import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomIntegTest {
    @Test
    public void example_integ_test() {
        String url = Optional.ofNullable(System.getenv("BOOT_APP_URL"))
                .orElse("http://localhost:8080");

        String response = new RestTemplate().exchange(url,
                HttpMethod.GET, new HttpEntity<>((String) null), String.class).getBody();

        assertThat(response).contains("Greetings from Spring Boot");
    }
}
