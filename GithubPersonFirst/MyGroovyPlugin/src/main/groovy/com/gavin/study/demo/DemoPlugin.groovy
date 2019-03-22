package com.gavin.study.demo

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

class DemoPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println "DemoPlugin start"
        /**
         * 供第三方调用传入
         * demoDomain{*     hello = "hi"
         *}*/
//        project.extensions.create("demoDomain", DemoDomain.class,"demoDomain")
//        project.extensions.create("pluginDomain", PluginInfo, "demo domain override")
//        println project.extensions.demoDomain.hello
        /**
         * 供第三方调用输出
         * 调用print(MAX_Length)
         */
        project.extensions.extraProperties.set("MAX_Length","1")

//        addBuildTimeListener(project.gradle)

        /**
         * 类似jar unittest等android 插件命令
         * 调用gradlew showHello
         */
        project.tasks.create("showHello", DemoTask.class)
        project.tasks.whenTaskAdded {
            println "DemoPlugin add task"
        }

        //闭包传入  多值声明  android配置
        /**
         *
         */
        def multiDomains = project.container(MultiDomain.class) // 声明一个
        multiDomains.all {
            sourceDir = project.file("src/docs/${name}") // 定义默认值
        }
        println "DemoPlugin end"

    }

    def setDefaultCon(android) {
        android.compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
        }
        android.dexOptions {
            preDexLibraries true
            javaMaxHeapSize "3g"
            dexInProcess = true
            maxProcessCount 12
        }
        android.lintOptions {
            // turn off checking the given issue id's
            disable 'TypographyFractions', 'TypographyQuotes'

            // Turns on checks for the issue IDs you specify. These checks are in
            // addition to the default lint checks.
            enable 'RtlHardcoded', 'RtlCompat', 'RtlEnabled'

            // To enable checks for only a subset of issue IDs and ignore all others,
            // list the issue IDs with the 'check' property instead. This property overrides
            // any issue IDs you enable or disable using the properties above.
            check 'NewApi', 'InlinedApi'

            // turn off  error occur
            abortOnError false

            // if true, only report errors.
            ignoreWarnings true
        }
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

    /**
    * 设置默认签名
    * @return
    */
    def getDefaultSigningConfig(alias, password, filename) {
        Closure closure = {
            keyAlias alias
            keyPassword password
            storeFile file(filename)
            storePassword password
            v1SigningEnabled true
            v2SigningEnabled false
        }
        return closure
    }

    /**
    * 设置apk输出名字
    * @param appName
    * @param applicationVariants
    * @return
    */
    def setApkName(String appName, applicationVariants) {
        //修改生成的apk名字
        applicationVariants.all { variants ->
            variants.outputs.all {
                variants.assemble.doLast {
                    def releaseApkName = appName + '_V' + appVersionName + '_Build' +
                            new Date().format("yyMMdd").toString() + '.apk'
                    outputFileName = releaseApkName
                    copy {
                        println './app/build/outputs/apk/release/' + outputFileName
                        from('./app/build/outputs/apk/release/' + outputFileName)
                        into('../apk/')
//                    rename(outputFileName, releaseApkName)
                    }
                }
            }
        }
    }
}
