package com.mqian.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by mqian on 2017/7/1.
 */
@ApiModel(value = "用户信息")
public class UserVo {

    @ApiModelProperty(value = "主键id 唯一标识符")
    private long id;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "年龄")
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
