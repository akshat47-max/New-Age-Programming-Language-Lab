package main

import (
	"fmt"
)

func main() {
	// task 1
	students := []string{"Alice", "Bob", "Charlie"}
	fmt.Println("Initial Slice:", students)

	students = append(students, "Diana")
	fmt.Println("After Adding 'Diana':", students)

	removeIndex := 1
	students = append(students[:removeIndex], students[removeIndex+1:]...)
	fmt.Println("After Removing index 1 ('Bob'):", students)

	updateIndex := 1
	students[updateIndex] = "Eve"
	fmt.Println("After Updating index 1 to 'Eve':", students)

	fmt.Println()

	// task 2
	subjectMarks := make(map[string]int)

	subjectMarks["Mathematics"] = 95
	fmt.Println("After Inserting Mathematics:", subjectMarks)

	subjectMarks["Physics"] = 88
	fmt.Println("After Inserting Physics:", subjectMarks)

	subjectMarks["Computer Science"] = 92
	fmt.Println("After Inserting Computer Science:", subjectMarks)

	subjectToLookup := "Physics"
	marks, exists := subjectMarks[subjectToLookup]
	if exists {
		fmt.Printf("Lookup ('%s'): Found with %d marks\n", subjectToLookup, marks)
	} else {
		fmt.Printf("Lookup ('%s'): Not found\n", subjectToLookup)
	}

	subjectToDelete := "Physics"
	delete(subjectMarks, subjectToDelete)
	fmt.Printf("After Deleting '%s': %v\n", subjectToDelete, subjectMarks)
}
