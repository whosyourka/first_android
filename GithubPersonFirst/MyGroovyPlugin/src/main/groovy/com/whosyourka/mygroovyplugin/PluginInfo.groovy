package com.whosyourka.mygroovyplugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs

class PluginInfo {

    @Input
    public String hello = 'hello world' // 定义了一个输入参数
    PluginInfo(String hello){
        this.hello = hello
    }

}
