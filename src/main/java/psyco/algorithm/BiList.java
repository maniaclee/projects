package psyco.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 */
public class BiList {
    public Object value;
    public BiList pre;
    public BiList next;

    public BiList(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        List<Object> re = Lists.newLinkedList();
        BiList list = this;
        for (; list != null; list = list.next) {
            re.add(list.value);
        }
        return re.toString();
    }
}