package psyco.motif;

import com.leacox.motif.tuple.Tuple2;
import org.junit.Test;

import java.util.stream.IntStream;

import static com.leacox.motif.MatchesAny.any;
import static com.leacox.motif.MatchesExact.eq;
import static com.leacox.motif.Motif.match;
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
    }
}
