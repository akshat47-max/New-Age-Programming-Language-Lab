
class Student(
    val rollNo: Int,
    val name: String?,
    val course: String?,
    val marks: Double?
)

fun Student.displayName(): String {
    return name ?: "Unknown Student"
}

fun Student.isPassed(): Boolean {
    return (marks ?: 0.0) >= 40.0
}

fun Student.getGrade(): String {
    val score = marks ?: 0.0
    return when {
        score >= 80 -> "A"
        score >= 60 -> "B"
        score >= 40 -> "C"
        else -> "Fail"
    }
}

class CourseReport {
    private val students = mutableListOf<Student>()

    fun student(
        rollNo: Int,
        name: String?,
        course: String?,
        marks: Double?
    ) {
        students.add(Student(rollNo, name, course, marks))
    }

    fun generate() {
        println("\n--- Student Report ---")

        students.forEach {
            println("${it.displayName()} - ${it.course ?: "Not Assigned"} - ${it.getGrade()}")
        }

        val passed = students.filter { it.isPassed() }

        println("\nPassed Students:")
        passed.forEach { println(it.displayName()) }

        val names = students.map { it.displayName() }
        println("\nAll Students: $names")

        val totalMarks = students.map { it.marks ?: 0.0 }.reduce { a, b -> a + b }
        println("Total Marks: $totalMarks")

        val grouped = students.groupBy { it.course ?: "Not Assigned" }

        println("\nStudents Grouped By Course:")
        grouped.forEach { (course, list) ->
            println("$course : ${list.size} students")
        }
    }
}

fun courseReport(block: CourseReport.() -> Unit) {
    val report = CourseReport()
    report.block()
    report.generate()
}

fun main() {
    courseReport {
        student(1, "Rahul", "Kotlin", 85.0)
        student(2, "Aman", "Java", 65.0)
        student(3, "Priya", "Kotlin", 90.0)
        student(4, null, "Java", 30.0)
        student(5, "Riya", null, 75.0)
    }
}
