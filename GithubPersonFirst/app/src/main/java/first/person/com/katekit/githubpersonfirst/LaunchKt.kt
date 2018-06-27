package first.person.com.katekit.githubpersonfirst

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

class LaunchKt{
    fun myLaunch(){
        val job1 = launch(Unconfined,CoroutineStart.LAZY) {
            var count = 0
            println("launch")
            while (true) {
                count++
                //delay()表示将这个协程挂起500ms
                delay(500)
                println("count::$count")
            }
        }

        //job2会立刻启动
        val job2 = async(CommonPool) {
            job1.start()
            println("async start")
            "ZhangTao"
        }

        launch() {
            delay(3000)
            job1.cancel()
            //await()的规则是：如果此刻job2已经执行完则立刻返回结果，否则等待job2执行
            println(job2.await())
        }
        println("async")
    }

    fun myList(){
        val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
        val readOnlyView: List<Int>
        readOnlyView = listOf(1,2,3)
        numbers.add(1,2)
        println(numbers)        // 输出 "[1, 2, 3]"
        val items = listOf(1, 2, 3, 4)
        println(readOnlyView)   // 输出 "[1, 2, 3, 4]"
    }

    fun myNull(){
        val readOnlyView: List<Int>? = null
        println("start:"+ readOnlyView?.size)
    }
    @Throws(Exception::class)
    fun myLetNull(){
        val listWithNulls: List<String?> = listOf("A", null)
        for (item in listWithNulls) {
            item?.let { println(it) } // 输出 A 并忽略 null
        }
        throw Exception("Name required")
    }


}