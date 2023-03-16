package com.qcxy.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("mini_goods")
@Data
public class GoodsEntity {
    private int id;

    @TableField("goods_sn")
    private String goodsSn;
}
