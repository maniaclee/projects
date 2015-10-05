package psyco.algorithm;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by lipeng on 15/9/17.
 * 设计包含min 函数的栈。
 * 定义栈的数据结构，要求添加一个min 函数，能够得到栈的最小元素。
 * 要求函数min、push 以及pop 的时间复杂度都是O(1)。
 */
public class P2_minStack {

    public List<MinStackElement> stack = Lists.newLinkedList();

    public void push(Comparable a) {
        if (stack.isEmpty()) {
            stack.add(new MinStackElement(a, 0));
            return;
        }
        MinStackElement min = stack.get(stack.size() - 1);
        Comparable minValue = stack.get(min.preMinIndex).value;
        int index = minValue.compareTo(a) < 0 ? min.preMinIndex : stack.size();
        stack.add(new MinStackElement(a, index));
    }

    public Comparable pop() {
        if (stack.isEmpty())
            throw new RuntimeException("stack is empty");
        return stack.remove(stack.size() - 1).value;
    }

    public Comparable min() {
        if (stack.isEmpty())
            throw new RuntimeException("stack is empty");
        return stack.get(stack.get(stack.size() - 1).preMinIndex).value;
    }

    @Test
    public void jsldkf() {
        push(3);
        push(1);
        System.out.println(min());
        push(0);
        push(5);
        System.out.println(min());
    }

    class MinStackElement {
        public Comparable value;
        int preMinIndex;

        public MinStackElement(Comparable value) {
            this.value = value;
        }

        public MinStackElement(Comparable value, int preMinIndex) {
            this.value = value;
            this.preMinIndex = preMinIndex;
        }
    }

}
