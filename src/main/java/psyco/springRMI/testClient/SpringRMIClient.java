package psyco.springRMI.testClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import psyco.springRMI.client.HelloService;

/**
 * Created by lipeng on 15/9/11.
 */

/**
 * disable DataSource
 */

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, EmbeddedServletContainerAutoConfiguration.class})
@ComponentScan(basePackages = {"psyco.springRMI.client", "psyco.springRMI.testClient"})
public class SpringRMIClient {
    @Bean
    public RmiProxyFactoryBean helloServiceConsumer() {
        RmiProxyFactoryBean re = new RmiProxyFactoryBean();
        re.setServiceInterface(HelloService.class);
        re.setServiceUrl("rmi://localhost:9999/hello");

        re.setCacheStub(true);
        re.setLookupStubOnStartup(true);
        re.setRefreshStubOnConnectFailure(true);
        return re;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext x = SpringApplication.run(SpringRMIClient.class, args);
        HelloService helloservice = x.getBean(HelloService.class);
        System.out.println(helloservice.echo("fuck"));
    }
}
