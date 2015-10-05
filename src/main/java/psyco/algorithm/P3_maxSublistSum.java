package psyco.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by lipeng on 15/9/17.
 * 求子数组的最大和
 * 题目：
 * 输入一个整形数组，数组里有正数也有负数。
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
 * 因此输出为该子数组的和18。
 */
public class P3_maxSublistSum {

    public int[] max(int[] a) {
        int max = 0;
        int sum = 0;
        int reLeft = -1;
        int reRight = -1;
        int left = -1;
        int right;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;
                left = i + 1;
            } else {
                right = i;
                if (sum > max) {
                    max = sum;
                    reLeft = left;
                    reRight = right;
                }
            }
        }
        return Arrays.copyOfRange(a, reLeft, reRight + 1);
    }

    @Test
    public void sdf() {
        int[] a = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(Arrays.toString(max(a)));
    }
}
