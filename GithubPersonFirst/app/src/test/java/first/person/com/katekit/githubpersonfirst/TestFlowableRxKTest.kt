package first.person.com.katekit.githubpersonfirst

import first.person.com.katekit.githubpersonfirst.test.CompanionKt
import first.person.com.katekit.githubpersonfirst.test.LaunchKt
import org.junit.Assert
import org.junit.Test

class TestFlowableRxKTest {
    @Test
    fun TestMyKt(){
//        var kta = TestFlowableRx("haha","lala")
//        var tt = Derived("haha","hehe");
        Assert.assertEquals(1,1)
    }
    @Test
    fun TestCompanion(){
        var comparablea = CompanionKt()
    }
    @Test
    fun TestLaunch(){
        var launch = LaunchKt()
        launch.myLaunch()
//        Thread.sleep(5000)
        Assert.assertEquals(1,1)
    }
    @Test
    fun TestNull(){
        var launch = LaunchKt()
        launch.myNull()
    }
    @Test
    fun TestLetNull(){
        var launch = LaunchKt()
//        try {
            println("2")
            launch.myLetNull()
//            val t = 1/0
            println("3")
//        }catch (e:Exception){
//            println("1")
//            e.printStackTrace()
//            println("4")
//        }

    }

}