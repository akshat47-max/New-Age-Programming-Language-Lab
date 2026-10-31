
package main

import (
	"fmt"
	"math"
	"strings"
)

// Division function
func divide(a, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf("division by zero is not allowed")
	}
	return a / b, nil
}

// Square root function
func squareRoot(n float64) (float64, error) {
	if n < 0 {
		return 0, fmt.Errorf("cannot calculate square root of a negative number")
	}
	return math.Sqrt(n), nil
}

// Input validation function
func validateInput(input string) error {
	if strings.TrimSpace(input) == "" {
		return fmt.Errorf("input cannot be empty")
	}
	return nil
}

func main() {
	fmt.Println("----- Error Handling in Go -----")

	// Valid division
	result, err := divide(10, 2)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Division Result:", result)
	}

	// Division by zero
	_, err = divide(10, 0)
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Valid square root
	root, err := squareRoot(25)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Square Root:", root)
	}

	// Negative square root
	_, err = squareRoot(-9)
	if err != nil {
		fmt.Println("Error:", err)
	}

	// Empty input
	err = validateInput("")
	if err != nil {
		fmt.Println("Error:", err)
	}
}
