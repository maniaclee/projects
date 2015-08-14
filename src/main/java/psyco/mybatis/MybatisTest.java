package psyco.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import psyco.mybatis.dal.mapper.AgeMapper;

import javax.annotation.Resource;

/**
 * Created by lipeng on 15/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"psyco.mybatis"})
@EnableTransactionManagement
@SpringApplicationConfiguration(classes = {MybatisTest.class})
public class MybatisTest {

    @Resource
    private AgeMapper ageMapper;

    @Test
    public void test() {
        System.out.println(ageMapper.findOne(3));
        System.out.println(ageMapper.findAll());
    }

}
