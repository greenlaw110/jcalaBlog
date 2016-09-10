package me.jcala.blog.mapping;

import me.jcala.blog.domain.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/8.
 */
@Repository
@Mapper
public interface InfoMapper {

    @Select({
        "select username,sex,real_name,",
            "email,website,github,",
            "linkedin,twitter,pro_exp,",
            "edu_exp,advantage ",
            "from admin limit 1"
    })
    Info select() throws Exception;

    @Select({
        "select count(*) ",
            "from admin ",
            "where username = #{un} ",
            "and password = #{pw}"
    })
    int selectByPw(@Param("un") String username, @Param("pw") String password) throws Exception;

    @Update({
        "update admin set username = #{if.username},",
                "email= #{if.email},website=#{if.website},",
                "github=#{if.github},linkedin=#{if.linkedin},",
                "twitter=#{if.twitter},pro_exp=#{if.pro_exp},",
                "edu_exp = #{if.edu_exp},advantage=#{if.advantage} ",
                "limit 1"
    })
    void update(@Param("if") Info info);

    @Select({
            "select count(*) ",
            "from admin ",
            "where password = #{pw}"
    })
    int selectByOldPass(@Param("pw") String oldPass) throws Exception;
}