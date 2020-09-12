package com.stochanskyi.itunescharts.utils

fun <T>MutableList<T>.clearAndAdd(newItems: List<T>) {
    this.clear()
    this.addAll(newItems)
}