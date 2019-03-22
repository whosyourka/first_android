package com.gavin.study.demo

import org.gradle.api.tasks.Input

class DemoDomain{
    @Input
    public String hello = 'hello world' // 定义了一个输入参数
    DemoDomain(String hello){
        this.hello = hello
    }

}
