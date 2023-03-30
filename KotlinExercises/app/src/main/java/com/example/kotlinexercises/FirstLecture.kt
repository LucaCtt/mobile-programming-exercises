package com.example.kotlinexercises

data class ExamResult(val name: String, val score: Int)

fun main() {
    val res = listOf(
        ExamResult("Mary", 91),
        ExamResult("John", 85),
        ExamResult("Raul", 42),
        ExamResult("Marta", 99),
        ExamResult("George", 89),
    )

    println("Grades:")
    res.forEach { println(" - ${it.name}: ${grade(it.score)} (${it.score})") }

    println("\nGrades over 90: ${checkThreshold(res, 90)}")
}

fun grade(score: Int): String {
    if ((90..100).contains(score)) {
        return "A"
    }

    if ((80..89).contains(score)) {
        return "B"
    }

    if ((70..79).contains(score)) {
        return "C"
    }

    return "F"
}

fun checkThreshold(grades: List<ExamResult>, threshold: Int): Int {
    return grades.count { it.score >= threshold }
}
