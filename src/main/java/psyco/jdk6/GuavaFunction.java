package psyco.jdk6;

import com.google.common.base.Optional;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.List;

/**
 * Created by lipeng on 15/9/24.
 */
public class GuavaFunction {

    @Test
    public void option() {
        Integer a = null;
        Integer b = 1;
        System.out.println(Optional.fromNullable(a).transform(input -> input.equals(2)).orNull());
    }

    @Test
    public void collection() {
        List<Integer> a = Lists.newArrayList(1, 3, 5, 2, 455, 333);
        a=Lists.newArrayList(Collections2.filter(a, input -> input > 3));
        System.out.println(a);
        System.out.println(Collections2.transform(a, input -> input.toString().length()));
    }

    @Test
    public void collectionSort() {
        List<Integer> a = Lists.newArrayList(100, 3, 5, 2, null, 455, 333);
        System.out.println(Ordering.natural().nullsLast().sortedCopy(a));
    }
}
