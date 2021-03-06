package life.chenyirui.community.mapper;


import life.chenyirui.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified) value(#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);


}
