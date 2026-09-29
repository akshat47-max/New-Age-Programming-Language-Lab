package main

import "fmt"

type Student struct {
	Name  string
	Age   int
	marks float32
}

func modifyValue(n *int) {
	*n = 100
}

func main() {
	// 1. Pointer usage
	x := 10
	ptr := &x

	fmt.Println("Address:", &x)
	fmt.Println("Value:", *ptr)

	// 2. Modify original variable
	fmt.Println("Before:", x)
	modifyValue(&x)
	fmt.Println("After:", x)

	// 3. Allocate struct using new()
	s := new(Student)
	s.Name = "Akshat"
	s.Age = 21
	s.marks = 95.5

	fmt.Println("Name:", s.Name)
	fmt.Println("Age:", s.Age)
	fmt.Println("marks:", s.marks)

	s.Age = 22
	fmt.Println("Updated Age:", s.Age)
}
