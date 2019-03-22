package com.gavin.study.demo

import org.gradle.api.Plugin
import org.gradle.api.Project

class DemoPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        println "DemoPlugin start"
//        project.gradle.addListener(new BuildTimeListener())
        /**
         * 供第三方调用传入
         * demoDomain{
         *     hello = "hi"
         * }
         */
        project.extensions.create("demoDomain", DemoDomain, "demo domain override")

        /**
         * 类似jar unittest等android 插件命令
         * 调用gradlew showHello
         */
        project.tasks.create("showHello", DemoTask.class)
        project.tasks.whenTaskAdded {
            println "DemoPlugin add task"
        }

        /**
         *
         */
        def multiDomains = project.container(MultiDomain.class) // 声明一个
        multiDomains.all {
            sourceDir = project.file("src/docs/${name}") // 定义默认值
        }

        println "DemoPlugin end"

    }
}
