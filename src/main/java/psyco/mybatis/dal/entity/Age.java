package psyco.mybatis.dal.entity;

import java.io.Serializable;

public class Age implements Comparable<Age>, Serializable {

    int _id;
    String _name;
    int _age;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_age() {
        return _age;
    }

    public void set_age(int _age) {
        this._age = _age;
    }

    @Override
    public String toString() {
        return "Age [_id=" + _id + ", _name=" + _name + ", _age=" + _age + "]";
    }

    @Override
    public int compareTo(Age o) {
        return this._age - o._age;
    }
}
