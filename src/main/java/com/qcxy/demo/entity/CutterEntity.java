package com.qcxy.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("mini_cutter")
public class CutterEntity {
   private int id;
   private String cutname;
   @TableField("goods_sn")
   private String goodsSn;
    @TableField("is_tag")
   private int isTag;
   private int status;
}
