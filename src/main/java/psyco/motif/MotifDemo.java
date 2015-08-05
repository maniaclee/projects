package psyco.motif;

import com.google.common.collect.Lists;
import com.leacox.motif.tuple.Tuple2;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.leacox.motif.MatchesAny.any;
import static com.leacox.motif.MatchesExact.eq;
import static com.leacox.motif.Motif.match;
import static com.leacox.motif.cases.ListConsCases.headNil;
import static com.leacox.motif.cases.ListConsCases.headTail;
import static com.leacox.motif.cases.ListConsCases.nil;
import static com.leacox.motif.cases.Tuple2Cases.tuple2;

/**
 * Created by lipeng on 15/7/24.
 */
public class MotifDemo {
    @Test
    public void fizzBuzz() {
        IntStream.range(0, 101).forEach(
                n -> System.out.println(
                        match(Tuple2.of(n % 3, n % 5))
                                .when(tuple2(eq(0), eq(0))).get(() -> "FizzBuzz")
                                .when(tuple2(eq(0), any())).get(y -> "Fizz")
                                .when(tuple2(any(), eq(0))).get(x -> "Buzz")
                                .orElse(String.valueOf(n))
                                .getMatch()
                )
        );
        IntStream.range(0, 101).forEach(
                n -> System.out.println(
                        match(Tuple2.of(n % 3, n % 5))
                                .when(tuple2(eq(0), eq(0))).get(() -> Lists.newArrayList())
                                .getMatch()
                )
        );
    }

    @Test
    public void sdfsdf() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        match(list)
                .when(nil()).then(() -> System.out.println("Empty List"))
                .when(headNil(eq("b"))).then(() -> System.out.println("Singleton List of 'b'"))
                .when(headNil(any())).then(head -> System.out.println("Singleton List of " + head))
                .when(headTail(any(), any())).then(
                (head, tail) -> System.out.println("head: " + head + " Remaining: " + tail))
                .doMatch();
    }
}
