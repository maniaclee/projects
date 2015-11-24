package psyco.springFactoryBean.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import psyco.springFactoryBean.BeanX;

import java.util.Map;

/**
 * Created by peng on 15/11/24.
 */
@Component
public class BeanFactoryPostProcessorTest  implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
       Map<String,BeanX> bs = configurableListableBeanFactory.getBeansOfType(BeanX.class);
        bs.values().forEach(beanX -> beanX.setName("fuckfuck"));
    }
}
