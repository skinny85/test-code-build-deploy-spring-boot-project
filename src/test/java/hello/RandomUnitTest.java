package hello;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUnitTest {
    @Test
    public void test_hello_controller() throws Exception {
        // given:
        HelloController helloController = new HelloController();

        // when:
        String response = helloController.index();

        // then:
        assertThat(response).contains("Greetings from the AWS CDK");
    }
}
