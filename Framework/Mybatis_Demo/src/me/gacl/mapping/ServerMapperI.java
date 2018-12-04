package me.gacl.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import me.gacl.domain.Server;

/**
 * @author gacl 定义sql映射的接口，使用注解指明方法要执行的SQL
 */
public interface ServerMapperI {

    // 使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into server(id, warehouse_name, slack_group, recipient_slackId, email_address, state, created_at, created_by, modified_at, modified_by, delete_flag) values(#{id,jdbcType=INTEGER}, #{warehouseName,jdbcType=VARCHAR}, #{slackGroup,jdbcType=VARCHAR}, #{recipients,jdbcType=VARCHAR}, #{emailAddresses,jdbcType=VARCHAR}, #{state,jdbcType=CHAR}, #{createdAt,jdbcType=TIMESTAMP}, #{createdBy,jdbcType=INTEGER}, #{modifiedAt,jdbcType=TIMESTAMP}, #{modifiedBy,jdbcType=INTEGER}, #{deleteFlag,jdbcType=CHAR})")
    public int add(Server server);

    // 使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from server where id=#{id}")
    public int deleteById(int id);

    // 使用@Update注解指明update方法要执行的SQL
    @Update("update server set warehouse_name = #{warehouseName,jdbcType=VARCHAR}, slack_group = #{slackGroup,jdbcType=VARCHAR}, recipient_slackId = #{recipients,jdbcType=VARCHAR}, email_address = #{emailAddresses,jdbcType=VARCHAR}, state = #{state,jdbcType=CHAR}, created_at = #{createdAt,jdbcType=TIMESTAMP}, created_by = #{createdBy,jdbcType=INTEGER}, modified_at = #{modifiedAt,jdbcType=TIMESTAMP}, modified_by = #{modifiedBy,jdbcType=INTEGER}, delete_flag = #{deleteFlag,jdbcType=CHAR} where id=#{id}")
    public int update(Server server);

    // 使用@Select注解指明getById方法要执行的SQL
    @Select("select id, warehouse_name warehouseName, slack_group slackGroup, recipient_slackId recipients, email_address emailAddresses, state, created_at createdAt, created_by createdBy, modified_at modifiedAt, modified_by modifiedBy, delete_flag deleteFlag from server where id=#{id}")
    public Server getById(int id);

    // 使用@Select注解指明getAll方法要执行的SQL
    @Select("select id, warehouse_name warehouseName, slack_group slackGroup, recipient_slackId recipients, email_address emailAddresses, state, created_at createdAt, created_by createdBy, modified_at modifiedAt, modified_by modifiedBy, delete_flag deleteFlag from server")
    public List<Server> getAll();
}
