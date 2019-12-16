package com.badminton.controller;

import com.badminton.bean.User;
import com.badminton.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ASUS on 2019/12/4.
 */
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //展示用户列表：
    @GetMapping("getUserList")
    @ResponseBody
    public List<User> getUserList(){

        List<User> userList = userRepository.findAll();
        if(userList == null){
            return null;
        }
        return userList;
    }
    //添加/修改用户：
    @PostMapping("addUser")
    public String addUser(User user){

        User user1 = userRepository.save(user);
        if (user1==null){
            return "failed";
        }
        return "success";

    }
    //删除用户：
    @PostMapping("deleteUser")
    public String deleteUser(String userId){

        User user = new User();
        user.setId(Integer.valueOf(userId));
        try {
            userRepository.delete(user);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }
    //批量删除用户：

    @PostMapping("deleteManyUser")
    public String deleteManyUser(@RequestParam("JsonDeleteManyId")String JsonDeleteManyId){

        String deleteIds ="";
        deleteIds =  JsonDeleteManyId.substring(0,JsonDeleteManyId.length()-1);
        deleteIds =  deleteIds.substring(1);

        List<String> result = Arrays.asList(deleteIds.split(","));

        try{
            for(String i : result){

                userRepository.deleteById(Integer.valueOf(i));
            }
        }catch (Exception e){
            return "failed";
        }

        return "success";
    }


}
