package psyco.multiDataSource.test.mapper;

import psyco.multiDataSource.core.DataSource;
import psyco.multiDataSource.test.entity.UserUser;

import java.util.List;

/**
 * Created by lipeng on 15/8/15.
 */
@DataSource("user")
public interface UserUserMapper {
    @DataSource("user")
    UserUser findOne(int id);

    @DataSource("user")
    List<UserUser> findAll();

}
