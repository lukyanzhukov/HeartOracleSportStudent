package com.heartoracle.sport.student.core.utils


import kotlin.collections.ArrayList


fun ArrayList<Int>.getMode(): Int {
    var count = 1
    var tempCount: Int
    var popular = this[0]
    var temp = 0
    for (i in 0 until this.size - 1) {
        temp = this[i]
        tempCount = 0
        for (j in 1 until this.size) {
            if (temp == this[j])
                tempCount++
        }
        if (tempCount > count) {
            popular = temp
            count = tempCount
        }
    }
    return popular
}