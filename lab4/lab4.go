package main

import (
	"fmt"
	"time"
)

func square(ch chan string) {
	fmt.Println("Square Goroutine Started")
	time.Sleep(1 * time.Second)
	ch <- "Square of 5 = 25"
	fmt.Println("Square Goroutine Completed")
}

func cube(ch chan string) {
	fmt.Println("Cube Goroutine Started")
	time.Sleep(2 * time.Second)
	ch <- "Cube of 3 = 27"
	fmt.Println("Cube Goroutine Completed")
}

func fibonacci(ch chan string) {
	fmt.Println("Fibonacci Goroutine Started")
	time.Sleep(3 * time.Second)
	ch <- "Fibonacci Series: 0 1 1 2 3 5"
	fmt.Println("Fibonacci Goroutine Completed")
}

func main() {
	ch := make(chan string)

	go square(ch)
	go cube(ch)
	go fibonacci(ch)

	// Collect and print results
	for i := 0; i < 3; i++ {
		result := <-ch
		fmt.Println(result)
	}

	fmt.Println("All tasks completed")
}
