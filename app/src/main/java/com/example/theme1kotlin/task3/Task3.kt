package com.example.theme1kotlin.task3

/*
* Написать extention-функцию для List, которая в рантайме будет искать Int в списке типа Any и возвращать его.
* Заранее подготовить список, наполненный разными классами(5-10 шт будет достаточно).
* По нажатию на кнопку выводить результат в логи (не использовать рефлексию).
*/

fun List<Any>.findInt(): Int = this.firstOrNull { it is Int } as Int
fun List<Any>.findListInt(): List<Int> = this.filterIsInstance<Int>() //для списка Интов

//Рандомный класс для добавления в список
class Test3Class