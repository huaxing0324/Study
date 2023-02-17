package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user(name,code,content,create_time)values(#{name},#{code},#{content},#{createTime})")
    int insert(UserEntity user);


    @Insert("<script>" +
            "insert into user(name,code,content,create_time) values\n" +
            "<foreach collection=\"users\" item=\"item\" separator=\",\">\n" +
            "\t(#{item.name,jdbcType=VARCHAR},#{item.code,jdbcType=VARCHAR},#{item.content,jdbcType=VARCHAR},#{item.createTime,jdbcType=DATE})\n" +
            "</foreach>" +
            "</script>")
    int batchInsert(@Param("users") List<UserEntity> users);
}
