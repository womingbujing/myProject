package com.qcxy.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qcxy.demo.entity.CutterEntity;
import com.qcxy.demo.entity.GoodsEntity;
import com.qcxy.demo.mapper.CutterMapper;
import com.qcxy.demo.mapper.GoodsMapper;
import com.qcxy.demo.service.MailService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class IndexController {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private CutterMapper cutterMapper;

    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private JavaMailSender javaMailSender;

    @ApiOperation("欢迎接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "id",value = "用户Id"),@ApiImplicitParam(name = "name",value = "用户名")})
    @GetMapping("index/{id}/{name}")
    public String welcome(@PathVariable(value = "id",required = false) int id,@PathVariable(value = "name",required = false) String name, Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "index/index";
    }

    //@RequestMapping("/test")
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "hello world";
    }



    @GetMapping("/select")
    @ResponseBody
    public List<CutterEntity> select(){
       /* GoodsEntity goodsEntity = goodsMapper.selectById(606);
        System.out.println(goodsEntity);
        return null;*/
        List<Float> list = new ArrayList<Float>();
        return cutterMapper.selectList(new QueryWrapper<CutterEntity>().eq("id",10));

    }

    @GetMapping("/update")
    @ResponseBody
    public List<CutterEntity> update(){
       /* GoodsEntity goodsEntity = goodsMapper.selectById(606);
        System.out.println(goodsEntity);
        return null;*/
        CutterEntity cutterEntity = new CutterEntity();
        cutterEntity.setId(10);
        cutterEntity.setGoodsSn("123457");//00002_0000002520
        cutterMapper.updateById(cutterEntity);

        return cutterMapper.selectList(new QueryWrapper<CutterEntity>().eq("id",10));

    }

    @GetMapping("/insert")
    @ResponseBody
    public List<CutterEntity> insert(){
       /* GoodsEntity goodsEntity = goodsMapper.selectById(606);
        System.out.println(goodsEntity);
        return null;*/
        CutterEntity cutterEntity = new CutterEntity();
        cutterEntity.setGoodsSn("456789");//00002_0000002520
        cutterEntity.setCutname("ceshi");
        cutterEntity.setIsTag(1);
        cutterEntity.setStatus(1);
        cutterMapper.insert(cutterEntity);

        return cutterMapper.selectList(new QueryWrapper<CutterEntity>().eq("cutname","ceshi"));

    }

    @GetMapping("/delete")
    @ResponseBody
    public List<CutterEntity> delete(){
       /* GoodsEntity goodsEntity = goodsMapper.selectById(606);
        System.out.println(goodsEntity);
        return null;*/
        cutterMapper.deleteById(75);

        return cutterMapper.selectList(new QueryWrapper<CutterEntity>().eq("cutname","ceshi"));

    }

    @GetMapping("/test2")
    @ResponseBody
    public List<CutterEntity> test2(){
       /* GoodsEntity goodsEntity = goodsMapper.selectById(606);
        System.out.println(goodsEntity);
        return null;*/
        return cutterMapper.selectList(new QueryWrapper<CutterEntity>().eq("id",10));

    }

    @GetMapping("getgoods")
    @ResponseBody
    public List<GoodsEntity> getgoods(){
       /* GoodsEntity goodsEntity = goodsMapper.selectById(606);
        System.out.println(goodsEntity);
        return null;*/
        return goodsMapper.selectList(new QueryWrapper<GoodsEntity>().gt("id",10));

    }



    @GetMapping("send")
    @ResponseBody
    public String send(){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 邮件发送来源
        simpleMailMessage.setFrom(mailProperties.getUsername());
        // 邮件发送目标
        simpleMailMessage.setTo("1769058919@qq.com");
        // 设置标题
        simpleMailMessage.setSubject("title");
        // 设置内容
        simpleMailMessage.setText("welcome");

        try {
            // 发送
            javaMailSender.send(simpleMailMessage);
        } catch (MailException e) {
            e.printStackTrace();
        }


        return "1";

    }

}
