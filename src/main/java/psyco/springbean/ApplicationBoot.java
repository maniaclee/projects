package psyco.springbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"psyco.springbean"})
public class ApplicationBoot {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationBoot.class, args);
    }
}