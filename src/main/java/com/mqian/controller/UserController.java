package com.mqian.controller;
import java.util.*;

import com.mqian.model.vo.UserVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * Created by mqian on 2017/7/1.  test 分支
 *
 * 在test分支中创建了一个名字 test
 *
 * 这句话 是可以同时存在的 必须有
 *
 * dev-mqian  必须有
 *
 * dev-mqian 新添加的 必须有
 *
 */
@RestController
@RequestMapping(value = "/UserVos") // 通过这里配置使下面的映射都在/UserVos下，可去除
public class UserController {

    static Map<Long, UserVo> UserVos = Collections.synchronizedMap(new HashMap<Long, UserVo>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public List<UserVo> getUserVoList() {
        List<UserVo> r = new ArrayList<UserVo>(UserVos.values());
        return r;
    }

    @ApiOperation(value = "创建用户", notes = "根据UserVo对象创建用户")
    @ApiImplicitParam(name = "UserVo", value = "用户详细实体UserVo", required = true, dataType = "UserVo")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUserVo(@RequestBody UserVo UserVo) {
        UserVos.put(UserVo.getId(), UserVo);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserVo getUserVo(@PathVariable Long id) {
        return UserVos.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的UserVo信息来更新用户详细信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "UserVo", value = "用户详细实体UserVo", required = true, dataType = "UserVo") })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUserVo(@PathVariable Long id, @RequestBody UserVo UserVo) {
        UserVo u = UserVos.get(id);
        u.setName(UserVo.getName());
        u.setAge(UserVo.getAge());
        UserVos.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserVo(@PathVariable Long id) {
        UserVos.remove(id);
        return "success";
    }

}

