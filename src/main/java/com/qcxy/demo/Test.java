package com.qcxy.demo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Test {
    private int a;
    private int b;
}
