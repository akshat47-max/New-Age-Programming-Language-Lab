
import java.util.Scanner

class Student(
    private var rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {

    fun acceptData(sc: Scanner) {
        print("Enter Roll Number: ")
        rollNo = sc.nextInt()
        sc.nextLine()

        print("Enter Name: ")
        name = sc.nextLine()

        print("Enter Course: ")
        course = sc.nextLine()

        print("Enter Percentage: ")
        percentage = sc.nextDouble()
        sc.nextLine()
    }

    fun displayDetails() {
        println("\n----- STUDENT DETAILS -----")
        println("Roll Number: $rollNo")
        println("Name: $name")
        println("Course: $course")
        println("Percentage: $percentage%")
    }
}

fun main() {
    val sc = Scanner(System.`in`)

    val student1 = Student(0, "", "", 0.0)
    val student2 = Student(0, "", "", 0.0)

    println("Enter First Student Details:")
    student1.acceptData(sc)
    student1.displayDetails()

    println("\nEnter Second Student Details:")
    student2.acceptData(sc)
    student2.displayDetails()

    sc.close()
}
