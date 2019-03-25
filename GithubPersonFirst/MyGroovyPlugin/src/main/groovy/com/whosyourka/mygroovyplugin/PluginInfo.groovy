package com.whosyourka.mygroovyplugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.incremental.IncrementalTaskInputs

class PluginInfo {

    @Input
    private String hello
    @Input
    private String alias
    @Input
    private String password
    @Input
    private String filename
    PluginInfo(String hello){
        this.hello = hello
    }

    PluginInfo(String hello, String alias) {
        this.hello = hello
        this.alias = alias
    }

    PluginInfo(String hello, String alias, String password) {
        this.hello = hello
        this.alias = alias
        this.password = password
    }

    PluginInfo(String hello, String alias, String password, String filename) {
        this.hello = hello
        this.alias = alias
        this.password = password
        this.filename = filename
    }

    String getHello() {
        return hello
    }

    void setHello(String hello) {
        this.hello = hello
    }

    String getAlias() {
        return alias
    }

    void setAlias(String alias) {
        this.alias = alias
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    String getFilename() {
        return filename
    }

    void setFilename(String filename) {
        this.filename = filename
    }
}
