package myutils

import (
	"math"
	"strings"
)

// String Function 1: Reverses a string
func Reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

// String Function 2: Counts the number of vowels in a string
func CountVowels(s string) int {
	vowels := "aeiouAEIOU"
	count := 0
	for _, char := range s {
		if strings.ContainsRune(vowels, char) {
			count++
		}
	}
	return count
}

// Math Function 1: Calculates the factorial of a non-negative integer
func Factorial(n int) int {
	if n < 0 {
		return -1 // Invalid input for factorial
	}
	result := 1
	for i := 1; i <= n; i++ {
		result *= i
	}
	return result
}

// Math Function 2: Calculates base raised to power exponent
func Power(base, exponent float64) float64 {
	return math.Pow(base, exponent)
}
