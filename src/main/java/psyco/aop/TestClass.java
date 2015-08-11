package psyco.aop;

import org.springframework.stereotype.Component;

/**
 * Created by lipeng on 15/8/11.
 */
@Component
public class TestClass {
    public String run(String words) {
        String re = String.format("fuck=>%s", words);
        System.out.println(re);
        return re;
    }
}
