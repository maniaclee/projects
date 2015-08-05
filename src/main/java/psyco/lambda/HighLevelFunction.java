package psyco.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * Created by lipeng on 15/8/5.
 */
public class HighLevelFunction {

    /**
     * combine multiple functions as a one function
     */
    public <R> Function<R, R> combine(Function<R, R> fn, Function<R, R> fn2) {
        return t -> fn.apply(fn2.apply(t));
    }

    public <R> Function<R, R> combine(Function<R, R>... fns) {
        return t -> {
            R re = t;
            for (int i = fns.length - 1; i >= 0; re = fns[i--].apply(re)) ;
            return re;
        };
    }

    public <T, R> Function<T, R> combine(Function<T, R> fn, Function<T, T>... fns) {
        return t -> fn.apply(combine(fns).apply(t));
    }


    /**
     * f(x)=x*x
     * a(x)=x*2
     * b(x)=x+1
     * <p>
     * f(b(x))=f(a(x)+1)
     */
    public Integer f(Integer a) {
        return a * a;
    }


    public Integer b(Integer a) {
        return a * 2;
    }

    public Integer a(Integer x) {
        return x + 1;
    }

    @Test
    public void testHighLevel() {
        Function<Integer, Integer> f = t -> t * t;
        Function<Integer, Integer> b = t -> t * 2;
        Function<Integer, Integer> a = t -> t + 1;
        Function<Integer, Integer> fn = combine(f, f,f,b, a);
        System.out.println(fn.apply(3));

    }

    @Test
    public void testNormal() {
        System.out.println(f(b(a(3))));
    }

    @Test
    public void test() {
        testHighLevel();
        testNormal();
    }

}
