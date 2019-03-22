package com.whosyourka.mygroovyplugin

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs

class PluginUtil extends DefaultTask{

    @TaskAction
    Closure getDefaultSigningConfig(IncrementalTaskInputs incrementalTaskInputs){

        println "getDefaultSigningConfig start"
        alias =  project.extensions.PluginInfo.hello
        password =  project.extensions.PluginInfo.hello
        filename =  project.extensions.PluginInfo.hello

        Closure closure = {
            keyAlias alias
            keyPassword password
            storeFile file(filename)
            storePassword password
            v1SigningEnabled true
            v2SigningEnabled false
        }
        println "getDefaultSigningConfig end"
        return closure
    }
}
