package psyco.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by lipeng on 15/8/6.
 */
@Component
public class SpringBeanTest implements ApplicationContextAware, ApplicationListener, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private int id;
    private ApplicationContext applicationContext;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * ApplicationContextAware
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("@@@@@@  setApplicationContext ");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (ContextRefreshedEvent.class.getName().equals(event.getClass().getName())) {
            System.out.println("==> application refresh");
        }
    }

    /**
     * BeanNameAware
     */
    @Override
    public void setBeanName(String s) {
        /** bean-name:  springBeanTest */
        System.out.println("my name is: " + s);
    }

    /**
     * InitializingBean
     * 等效@PostConstruct
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("test ApplicationContextAware");
        SpringBean b = this.applicationContext.getBean(SpringBean.class);
        System.out.println(b);
    }

    /**
     * DisposableBean
     * 等效@PreDestroy
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBeanTest-----: ---------stopped");
    }
}
