import hello.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomIntegTest {
    private String url;
    private ConfigurableApplicationContext springContext;

    @Before
    public void setUp() {
        // re-set the context
        springContext = null;

        String envVariable = System.getenv("BOOT_APP_URL");
        if (envVariable != null) {
            // the server has been started for us - nothing to do
            url = envVariable;
        } else {
            // start the server
            springContext = Application.run();
            url = "http://localhost:8080";
        }
    }

    @After
    public void tearDown() {
        if (springContext != null) {
            springContext.close();
        }
    }

    @Test
    public void example_integ_test() {
        String response = new RestTemplate().exchange(url,
                HttpMethod.GET, new HttpEntity<>((String) null), String.class).getBody();

        assertThat(response).contains("Greetings from the AWS CDK");
    }
}
