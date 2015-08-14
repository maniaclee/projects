package psyco.mybatis.dal.mapper;

import psyco.mybatis.dal.entity.Age;

import java.util.List;

/**
 * Created by lipeng on 15/8/15.
 */
public interface AgeMapper {
    /*@Results({
            @Result(property = "id", column = "id"),
            @Result(property = "age", column = "age"),
            @Result(property = "name", column = "name")
    })
    @Select("select * from age where id=#{id}")*/
    Age findOne(int id);

    List<Age> findAll();


}
