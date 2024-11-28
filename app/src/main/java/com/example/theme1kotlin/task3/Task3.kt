package com.example.theme1kotlin.task3

/*
* Написать extention-функцию для List, которая в рантайме будет искать Int в списке типа Any и возвращать его.
* Заранее подготовить список, наполненный разными классами(5-10 шт будет достаточно).
* По нажатию на кнопку выводить результат в логи (не использовать рефлексию).
*/

fun List<Any>.findInt(): List<Int> {
    val result = mutableListOf<Int>()

    this.forEach {
        if (it is Int) result.add(it)
    }
    return result //либо можно просто воспользоваться встроенной функцией: return this.filterIsInstance<Int>()
}

//Рандомный класс для добавления в список
class Test3Class