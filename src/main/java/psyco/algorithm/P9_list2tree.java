package psyco.algorithm;

import org.junit.Test;

/**
 * Created by lipeng on 15/9/17.
 * 判断整数序列是不是二元查找树的后序遍历结果
 * 题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。
 * 如果是返回true，否则返回false。
 * 例如输入5,7,6,9,11,10,8，由于这一整数序列是如下树的后序遍历结果：
 * 8
 * / \
 * 6 10
 * / \ / \
 * 5 7 9 11
 * 因此返回true。
 * 如果输入7,4,6,5，没有哪棵树的后序遍历的结果是这个序列，因此返回false。
 */
public class P9_list2tree {

    public boolean list2tree(int[] a) {
        return list2tree(a, 0, a.length - 1);
    }

    public boolean list2tree(int[] a, int left, int right) {
        if (left >= right)
            return true;
        int root = a[right];
        int mid = right;
        for (; mid >= 0 && a[mid] >= root; mid--) ;
        for (int i = left; i <= mid; i++)
            if (a[i] >= root)
                return false;
        if (!list2tree(a, left, mid))
            return false;
        if (!list2tree(a, mid + 1, right - 1))
            return false;
        return true;

    }

    @Test
    public void sdfsdf() {
//        int[] a = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] a = new int[]{7, 4, 6, 5};
        System.out.println(list2tree(a));
    }
}
