
fun displayDetails(name: String = "Rahul", age: Int = 21) {
    println("Name: $name")
    println("Age: $age")
}

fun addNumbers(vararg numbers: Int) {
    println("Numbers:")
    for (num in numbers) {
        println(num)
    }
}

fun calculate(numbers: List<Int>, operation: (Int) -> Int) {
    val result = numbers.map(operation)
    println("Result: $result")
}

fun main() {

    println("----- DEFAULT PARAMETERS -----")
    displayDetails()
    displayDetails("Amit", 22)

    println("\n----- NAMED ARGUMENTS -----")
    displayDetails(age = 25, name = "Akash")

    println("\n----- VARARG FUNCTION -----")
    addNumbers(10, 20, 30, 40, 50)

    println("\n----- HIGHER ORDER FUNCTION -----")
    val numbers = listOf(1, 2, 3, 4, 5)

    calculate(numbers) { it * it }
}
