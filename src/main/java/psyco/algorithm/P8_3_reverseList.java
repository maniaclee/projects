package psyco.algorithm;

import org.junit.Test;

/**
 * Created by lipeng on 15/9/17.
 * 用一种算法来颠倒一个链接表的顺序。现在在不用递归式的情况下做一遍
 */
public class P8_3_reverseList {

    public SingleList reverseRecursive(SingleList list) {
        if (list == null || list.next == null)
            return list;
        SingleList tmp = reverseRecursive(list.next);
        list.next.next = list;
        list.next = null;
        return tmp;
    }

    public SingleList reverse(SingleList list) {
        SingleList tail = null;
        SingleList head = null;
        while (list != null) {
            tail = list.next;
            list.next = head;
            head = list;
            list = tail;
        }
        return head;

    }

    @Test
    public void sdfsdf() {
        SingleList re = SingleList.from(new Object[]{3, 1, 4, 5, 6, -1});
        System.out.println(re);
//        System.out.println(reverseRecursive(re));
        System.out.println(reverse(re));
    }

}
