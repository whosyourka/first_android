package first.person.com.katekit.githubpersonfirst

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class DelegateKt(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}
