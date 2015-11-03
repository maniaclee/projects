package psyco.multiDataSource.test.mapper;

import psyco.multiDataSource.core.DataSource;
import psyco.multiDataSource.test.config.Consts;
import psyco.multiDataSource.test.entity.User;

import java.util.List;

/**
 * Created by lipeng on 15/8/15.
 */
@DataSource(Consts.pro)
public interface UserMapper {
    User findOne(int id);

    List<User> findAll();


}
