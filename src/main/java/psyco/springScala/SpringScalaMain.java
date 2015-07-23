package psyco.springScala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by lipeng on 15/7/23.
 */


@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"psyco.springScala"})
public class SpringScalaMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringScalaMain.class, args);
    }

}
