package psyco.springRMI.client;

import java.io.Serializable;

/**
 * Created by lipeng on 15/9/11.
 */
public class Data implements Serializable{
    public String name;
    public int id ;

    public Data(String name, int id) {
        this.name = name;
        this.id = id;
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
        return "Data{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
