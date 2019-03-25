package com.whosyourka.mygroovyplugin

import com.gavin.study.demo.DemoDomain
import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.api.tasks.TaskState
import org.gradle.util.Clock

class MyPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {

        println "MyPlugin start"
        addBuildTimeListener(project.gradle)

        project.extensions.create("demoDomain", DemoDomain.class, "demoDomain")
        project.extensions.create("pluginInfo", PluginInfo.class,"pluginInfo")
        project.tasks.create("pluginUtilTask", PluginUtilTask.class)
        project.tasks.create("showHello", DemoTask.class)

        project.tasks.whenTaskAdded {
            println("whenTaskAdded start")
            println(project.extensions.pluginInfo.alias)
            println("whenTaskAdded end")

        }

        project.afterEvaluate {
            println("afterEvaluate start")
            println(project.extensions.pluginInfo.alias)
            println("afterEvaluate end")
            pluginUtilTask.dependsOn showHello
        }
        println(project.extensions.pluginInfo.alias)
        println "MyPlugin end"
    }

    /**
     * 配置构建时间
     * @param gradle
     * @return
     */
    def addBuildTimeListener(gradle) {
        gradle.addListener(new BuildTimeListener())
    }

    class BuildTimeListener implements TaskExecutionListener, BuildListener {
        private Clock clock
        private times = []

        @Override
        void beforeExecute(Task task) {
            clock = new org.gradle.util.Clock()
        }

        @Override
        void afterExecute(Task task, TaskState taskState) {
            def ms = clock.timeInMs
            times.add([ms, task.path])

            //task.project.logger.warn "${task.path} spend ${ms}ms"
        }

        @Override
        void buildFinished(BuildResult result) {
            println "Task spend time:"
            for (time in times) {
                if (time[0] >= 50) {
                    printf "%7sms  %s\n", time
                }
            }
        }

        @Override
        void buildStarted(Gradle gradle) {}

        @Override
        void projectsEvaluated(Gradle gradle) {}

        @Override
        void projectsLoaded(Gradle gradle) {}

        @Override
        void settingsEvaluated(Settings settings) {}
    }
}
