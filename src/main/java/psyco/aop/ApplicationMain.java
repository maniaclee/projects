package psyco.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lipeng on 15/8/11.
 */
@ComponentScan(basePackages = {"psyco.aop"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ApplicationMain.class})
@EnableAspectJAutoProxy
public class ApplicationMain {
    @Resource
    private TestClass testClass;

    @Test
    public void aop() {
        testClass.run("what the hell");
    }
}
