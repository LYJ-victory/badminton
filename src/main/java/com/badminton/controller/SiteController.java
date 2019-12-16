package com.badminton.controller;

import com.badminton.bean.Site;
import com.badminton.repository.SiteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ASUS on 2019/12/7.
 */
@CrossOrigin
@RestController
public class SiteController {

    @Autowired
    private SiteRespository siteRespository;

    //场地列表：
    @GetMapping("getSiteList")
    public List<Site> getSiteList(){

        List<Site> siteList = siteRespository.findAll();
        System.out.println("查询");
        if(siteList == null){
            return null;
        }
        return siteList;
    }
    //增加、修改场地：
    @PostMapping("addSite")
    public String addSite(Site site){
        //1.代表true表示空闲
        //0.代表false表示占用
        System.out.println();
        try{
            siteRespository.save(site);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }
    //删除场地;
    @PostMapping("deleteSite")
    public String delete(String id){
        Site site = new Site();
        site.setId(Integer.valueOf(id));
        try{
            siteRespository.delete(site);
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }
    //批量删除场地;
    @PostMapping("deleteManySite")
    public String deleteManySite(@RequestParam("JsonDeleteManyId")String JsonDeleteManyId){

        System.out.println(JsonDeleteManyId);

        JsonDeleteManyId = JsonDeleteManyId.substring(0,JsonDeleteManyId.length()-1);//删除的位置
        JsonDeleteManyId = JsonDeleteManyId.substring(1);//删除第一个字符
        System.out.println(JsonDeleteManyId);

        List<String> result = Arrays.asList(JsonDeleteManyId.split(","));
        System.out.println(result);

        try{
            for(String i : result){
                siteRespository.deleteById(Integer.valueOf(i));
            }
        }catch (Exception e){
            return "failed";
        }

        return "success";
    }
}
