package psyco.algorithm;

import org.junit.Test;

/**
 * Created by lipeng on 15/9/17.
 * 把二元查找树转变成排序的双向链表。
 * 题目：
 * 输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只调整指针的指向。
 * 10
 * / \
 * 6 14
 * / \ / \
 * 4 8 12 16
 * 转换成双向链表
 * 4=6=8=10=12=14=16。
 */
public class P1_Tree2list {


    /**
     * 用后序遍历来解决stack的先进先出！
     */
    public BiList tree2list(Node n) {
        BiList list = new BiList(n);
        helper(n, list);
        return list.next;
    }

    private void helper(Node n, BiList re) {
        if (n.right != null)
            helper(n.right, re);
        /** 后序遍历，每次都返回表头！ */
        BiList tmp = new BiList(n.value);
        tmp.next = re.next;
        re.next = tmp;

        if (n.left != null)
            helper(n.left, re);
    }

    @Test
    public void testsd() {
        System.out.println(Node.testData());
        System.out.println(tree2list(Node.testData()));
    }
}

