package psyco.springFactoryBean;

/**
 * Created by lipeng on 15/8/10.
 */
public class BeanX {
    String name;
    int id;

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
        return "BeanX{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
