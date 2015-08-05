package psyco.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lipeng on 15/8/5.
 */
public class SDsdfsdfsdfdsf {

    static final List<String> symbols = Arrays.asList(
            "AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
            "AMZN", "CRAY", "CSCO", "DELL", "GOOG", "INTC", "INTU",
            "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");
    static final IntStream intStream = IntStream.range(1, 100);

    @Test
    public void reduce() {
        String re = symbols.stream().reduce((s, s2) -> s.compareTo(s2) > 0 ? s : s2).get();
        System.out.println(re);
    }

    @Test
    public void reduceJoin() {
        System.out.println(symbols.stream().reduce((s, s2) -> s + s2).get());
    }

    @Test
    public void join() {
        System.out.println(symbols.stream().collect(Collectors.joining(",")));
        System.out.println(symbols.stream().collect(Collectors.joining()));
    }

    @Test
    public void intStream() {
        System.out.println(symbols.stream().mapToInt(value -> value.charAt(0)).sum());
        System.out.println(intStream.skip(10).collect(() -> Lists.newArrayList(), (objects, value) -> objects.add(value), (objects1, objects2) -> objects1.addAll(objects2)));
    }

    @Test
    public void patition() {
        Map<Boolean, List<String>> map = symbols.stream().collect(Collectors.partitioningBy(s -> s.startsWith("A")));
        System.out.println(map);
    }
}
