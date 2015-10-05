package psyco.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 */
public class SingleList {
    public Object value;
    public SingleList next;

    public SingleList(Object value) {
        this.value = value;
    }

    public static SingleList from(Object[] os) {
        SingleList re = null;
        SingleList tail = null;
        for (Object e : os) {
            if (tail == null) {
                tail = new SingleList(e);
                re = tail;
            } else {
                tail.next = new SingleList(e);
                tail = tail.next;
            }

        }
        return re;
    }

    @Override
    public String toString() {
        List<Object> re = Lists.newLinkedList();
        SingleList list = this;
        for (; list != null; list = list.next) {
            re.add(list.value);
        }
        return re.toString();
    }
}