package com.example.theme1kotlin.task4

/*
Написать шейкерную сортировку для List<Int?>. Учесть кейсы, когда переданный массив = null,
некоторые эл-ты массива = null - пушить такие эл-ты в конец сортированного списка.
*/

fun main() {
    val list = listOf(3, null, 5, 2, null, 1, 4, null)
    println(list.shakerSort())
}

fun List<Int?>?.shakerSort(): List<Int?>? {
    if (this.isNullOrEmpty()) return null

    val list = this.filterNotNull().toMutableList()

    var swapped: Boolean
    var start = 0
    var end = list.size - 1

    do {
        swapped = false

        for (i in start until end) {
            if (list[i] > list[i + 1]) {
                val temp = list[i]
                list[i] = list[i + 1]
                list[i + 1] = temp
                swapped = true
            }
        }

        if (!swapped) break
        swapped = false
        end--

        for (i in end downTo start + 1) {
            if (list[i - 1] > list[i]) {
                val temp = list[i]
                list[i] = list[i - 1]
                list[i - 1] = temp
                swapped = true
            }
        }
        start++
    } while (swapped)

    val nullCount = this.size - list.size
    return list + List(nullCount) { null }
}