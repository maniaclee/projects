package psyco.springFactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * Created by lipeng on 15/8/10.
 */
public class BeanFactoryBean implements FactoryBean<BeanX> {
    @Resource
    private ApplicationContext applicationContext;
    String name;
    int id;

    @Override
    public BeanX getObject() throws Exception {
        BeanX beanX = new BeanX();
        if (name != null)
            beanX.setName("[Factory]" + name);
        if (id > 0)
            beanX.setId(1000 * id);
        return beanX;
    }

    @Override
    public Class<?> getObjectType() {
        return BeanX.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
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
}
