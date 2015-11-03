package psyco.multiDataSource.test.mapper;

import psyco.multiDataSource.core.DataSource;
import psyco.multiDataSource.test.entity.User;

import java.util.List;

/**
 * Created by lipeng on 15/8/15.
 */
@DataSource("pro")
public interface UserMapper {
    @DataSource("pro")
    User findOne(int id);

    @DataSource("pro")
    List<User> findAll();


}
