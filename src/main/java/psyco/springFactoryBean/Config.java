package psyco.springFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lipeng on 15/8/10.
 */
@Configuration
public class Config {

    @Bean
    public BeanFactoryBean beanFactoryBean() {
        BeanFactoryBean factory = new BeanFactoryBean();
        factory.setId(33);
        factory.setName("sdfxxxx");
        return factory;
    }


}
