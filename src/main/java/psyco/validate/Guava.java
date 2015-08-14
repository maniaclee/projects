package psyco.validate;

import org.junit.Test;

import javax.annotation.Nonnull;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by lipeng on 15/8/14.
 */
public class Guava {

    public void checkNotNulltest(String s) {
        checkNotNull(s, "check not null test:%s", "shit");
        System.out.println("print:" + s);
    }

    public void notNull(@Nonnull String s) {
        System.out.println("nonnull:" + s);
    }

    @Test
    public void stet() {
//        checkNotNulltest(null);
//        notNull(null);

        String s = "fuck";
        System.out.println(Optional.ofNullable(s).map(e -> e.toUpperCase()).orElse("null"));
    }


}
