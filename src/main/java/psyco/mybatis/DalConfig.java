package psyco.mybatis;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by lipeng on 15/8/15.
 */
@Configuration
@MapperScan(basePackages = {"psyco.mybatis.dal.mapper"})
public class DalConfig {
    @Value(value = "classpath:mybatis/sqlmap/*.xml")
    private Resource[] mapperLocations;

    @Value(value = "classpath:mybatis/mybatis-config.xml")
    private Resource configLocation;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws SQLException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        sqlSessionFactoryBean.setConfigLocation(configLocation);
        return sqlSessionFactoryBean;
    }


    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/project-pro?characterEncoding=UTF-8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("");
        druidDataSource.setMaxActive(60);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMaxWait(60000);//60s
        druidDataSource.setMinIdle(1);
        druidDataSource.setTimeBetweenEvictionRunsMillis(3000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("select 1");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        druidDataSource.setFilters("config");
        Properties properties = new Properties();
        properties.put("config.decrypt", "true");
        druidDataSource.setConnectProperties(properties);
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(10000);//10s。。慢
        statFilter.setMergeSql(true);
        statFilter.setLogSlowSql(true);
        druidDataSource.setProxyFilters(Lists.newArrayList(statFilter));
        return druidDataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(druidDataSource());
    }

    @Bean(autowire = Autowire.BY_NAME)
    public TransactionTemplate transactionTemplate() {
        return new TransactionTemplate();
    }
}
