
fun main() {

    println("Hello Kotlin!!!")

    println("\n----- EMPLOYEE BONUS -----")

    print("Enter Department Code (IT/HR/FINANCE): ")
    val dept = readLine()!!.uppercase()

    print("Enter Years of Experience: ")
    val years = readLine()!!.toInt()

    print("Enter Employee Salary: ")
    val salary = readLine()!!.toDouble()

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
    var num = readLine()!!.toLong()

    num = kotlin.math.abs(num)

    var sum = 0
    var count = 0

    while (num > 0) {
        val digit = (num % 10).toInt()
        sum += digit
        count++
        num /= 10
    }

    if (count > 0) {
        val average = sum.toDouble() / count
        println("Sum of Digits: $sum")
        println("Average of Digits: $average")
    } else {
        println("Average of Digits: 0.0")
    }
}
