/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package test

import kotlin.reflect.KProperty


data class Info(
    var value: Int
) {
    operator fun getValue(c: C, property: KProperty<*>): Int {
        return value
    }
}

class C(var info: Info) {
    val value by info
}

fun main() {
    val info = Info(1)
    val c = C(info)
    println(c.value) //1
    info.value = 2
    println(c.value) //2
    c.info = Info(3)
    println(c.value) //2
}