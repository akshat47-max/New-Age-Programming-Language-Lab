
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    println("Hello Kotlin!!!")

    println("\n----- EMPLOYEE BONUS -----")

    print("Enter Department Code (IT/HR/FINANCE): ")
    val dept = sc.next().uppercase()

    print("Enter Years of Experience: ")
    val years = sc.nextInt()

    print("Enter Employee Salary: ")
    val salary = sc.nextDouble()

    val bonusPercent = when {
        dept == "IT" && years > 5 -> 20
        dept == "HR" && years > 3 -> 15
        dept == "FINANCE" && years > 4 -> 18
        else -> 10
    }

    val bonus = salary * bonusPercent / 100

    println("Bonus Percentage: $bonusPercent%")
    println("Bonus Amount: $bonus")

    println("\n----- DIGIT AVERAGE -----")

    print("Enter an integer: ")
    var num = sc.nextLong()

    num = kotlin.math.abs(num)

    var sum = 0
    var count = 0

    if (num == 0L) {
        count = 1
    }

    while (num > 0) {
        val digit = (num % 10).toInt()
        sum += digit
        count++
        num /= 10
    }

    val average = sum.toDouble() / count

    println("Sum of Digits: $sum")
    println("Average of Digits: $average")

    sc.close()
}
