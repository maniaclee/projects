package psyco.multiDataSource.test.entity;

import java.io.Serializable;

public class User implements  Serializable {

    int _id;
    String _name;
    String _email;

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

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", _name='" + _name + '\'' +
                ", _email='" + _email + '\'' +
                '}';
    }
}
