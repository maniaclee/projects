package psyco.springboot.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by lipeng on 15/7/21.
 */
@XmlRootElement
public class Message {
    private String name;
    private int id;
    private List<String> children;

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

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }
}
