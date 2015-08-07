package psyco.springbean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by lipeng on 15/8/6.
 */
@Component
public class SpringBean {
    private String name="springbean";
    private int id=9;

    @PostConstruct
    public void init() {
        System.out.println("xxxxxxxxxxxxxxSpringBean:start");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("xxxxxxxxxxxxxxSpringBean: ---------stopped");
    }

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

    @Override
    public String toString() {
        return "SpringBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
