package com.qcxy.demo.bean;

import lombok.Data;


@Data
public class Attribute {
    //品类
    String cate;

    //成品尺寸
    String productSize;

    //展开尺寸
    String openSize;

    //表面处理
    String surface;

    //纸张材质
    String paper;

    //印刷方式
    String printType;

    //成品内尺寸
    String internalDimension;

    //成品外尺寸
    String externalDimension;

    //纸盒材质
    String cartonMaterial;

    //烫金
    String gild;

    //粘合
    String stick;

    //开窗
    String openwin;

    //局部UV
    String localUv;

    //击凸
    String emboss;

    //击凹
    String concave;

    //贴窗
    String putwin;

    //刀卡一尺寸
    String cardSize1;

    //刀卡二尺寸
    String cardSize2;



    //切成品
    String cutProducts;

}

