package psyco.multiDataSource.test.mapper;

import psyco.multiDataSource.core.DataSource;
import psyco.multiDataSource.test.entity.UserUser;

import java.util.List;

/**
 * Created by lipeng on 15/8/15.
 */
@DataSource("user")
public interface UserUserMapper {
    UserUser findOne(int id);

    List<UserUser> findAll();

}
