package psyco.springRMI.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import psyco.springRMI.client.HelloService;

import javax.annotation.Resource;

/**
 * Created by lipeng on 15/9/11.
 */

/**
 * disable DataSource
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"psyco.springRMI.client", "psyco.springRMI.server"})
public class SpringRMIServer {

    @Resource
    private HelloService helloService;

    @Bean
    public RmiServiceExporter helloServiceExport() {
        RmiServiceExporter re = new RmiServiceExporter();
        re.setServiceInterface(HelloService.class);
        re.setService(helloService);
        re.setServiceName("hello");
        re.setRegistryPort(9999);
        return re;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRMIServer.class, args);
    }
}
