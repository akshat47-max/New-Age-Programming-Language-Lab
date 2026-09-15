package main

import (
	"custom-package-demo/myutils"
	"fmt"
)

func main() {
	fmt.Println("=== Custom Package Utility Demonstration ===")

	// Demonstrating String Functions
	strInput := "Go Programming"

	reversedStr := myutils.Reverse(strInput)
	fmt.Printf("1. Reverse('%s'): %s\n", strInput, reversedStr)

	vowelCount := myutils.CountVowels(strInput)
	fmt.Printf("2. CountVowels('%s'): %d\n", strInput, vowelCount)

	fmt.Println()

	// Demonstrating Math Functions
	factNum := 5
	factResult := myutils.Factorial(factNum)
	fmt.Printf("3. Factorial(%d): %d\n", factNum, factResult)

	base, exp := 2.0, 5.0
	powResult := myutils.Power(base, exp)
	fmt.Printf("4. Power(%.0f, %.0f): %.0f\n", base, exp, powResult)
}
