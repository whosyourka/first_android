package first.person.com.katekit.githubpersonfirst.test

class CompanionKt {
    init {
        create()
        print("myclass")
    }
    var ttt: String = ""
    companion object  {
        fun create() {
            println("crate")
        }
    }
    fun youar(){
        create()
    }
    fun test(){
        create()
    }
}
