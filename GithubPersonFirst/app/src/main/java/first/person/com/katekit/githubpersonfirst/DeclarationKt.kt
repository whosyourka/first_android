package first.person.com.katekit.githubpersonfirst
class DeclarationKt {
    interface Source<out T> {
        fun nextT(): T
    }

    fun demo(strs: Source<Double>) {
        val objects: Source<Number> = strs // 这个没问题，因为 T 是一个 out-参数
    }


    interface Comparable<in T> {
        operator fun compareTo(other: T): Int
    }

    fun demo(x: Comparable<Number>) {
        x.compareTo(1.0) // 1.0 拥有类型 Double，它是 Number 的子类型
        // 因此，我们可以将 x 赋给类型为 Comparable <Double> 的变量
        val y: Comparable<Double> = x // OK！
    }
}