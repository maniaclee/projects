package psyco.springQuartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lipeng on 15/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {SpringQuartzTest.class})
@ComponentScan(basePackages = {"psyco.springQuartz"})
@EnableAutoConfiguration
public class SpringQuartzTest {

    @Test
    public void test() {
    }

}
