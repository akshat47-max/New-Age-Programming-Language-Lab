
package main

import "testing"


func TestDivide(t *testing.T) {
	result, err := divide(10, 2)

	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}

	if result != 5 {
		t.Errorf("Expected 5, got %v", result)
	}
}


func TestDivideByZero(t *testing.T) {
	_, err := divide(10, 0)

	if err == nil {
		t.Error("Expected division by zero error")
	}
}


func TestSquareRoot(t *testing.T) {
	result, err := squareRoot(25)

	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}

	if result != 5 {
		t.Errorf("Expected 5, got %v", result)
	}
}


func TestNegativeSquareRoot(t *testing.T) {
	_, err := squareRoot(-9)

	if err == nil {
		t.Error("Expected negative square root error")
	}
}


func TestEmptyInput(t *testing.T) {
	err := validateInput("")

	if err == nil {
		t.Error("Expected empty input error")
	}
}


func TestValidInput(t *testing.T) {
	err := validateInput("Hello Go")

	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}
}
