package main

import (
	"errors"
	"fmt"
)

type Product struct {
	ProductID   int
	ProductName string
	Stock       int
	UnitPrice   float64
}

var productList []Product

func AddProduct(p Product) error {
	if p.ProductID <= 0 {
		return errors.New("product ID must be positive")
	}

	if p.ProductName == "" {
		return errors.New("product name is required")
	}

	if p.Stock < 0 {
		return errors.New("stock cannot be negative")
	}

	if p.UnitPrice <= 0 {
		return errors.New("price must be greater than zero")
	}

	for _, oldProduct := range productList {
		if oldProduct.ProductID == p.ProductID {
			return errors.New("product already exists")
		}
	}

	productList = append(productList, p)
	return nil
}

func UpdateProduct(id int, newStock int, newPrice float64) error {
	for index := range productList {
		if productList[index].ProductID == id {
			if newStock < 0 {
				return errors.New("invalid stock value")
			}

			if newPrice <= 0 {
				return errors.New("invalid price")
			}

			productList[index].Stock = newStock
			productList[index].UnitPrice = newPrice
			return nil
		}
	}

	return errors.New("product not found")
}

func DeleteProduct(id int) error {
	for position, p := range productList {
		if p.ProductID == id {
			productList = append(
				productList[:position],
				productList[position+1:]...,
			)
			return nil
		}
	}

	return errors.New("product not found")
}

func ShowProducts() {
	fmt.Println("\n Product Inventory ")

	for _, p := range productList {
		fmt.Printf(
			"ID: %d | Name: %s | Stock: %d | Price: Rs. %.2f\n",
			p.ProductID,
			p.ProductName,
			p.Stock,
			p.UnitPrice,
		)
	}
}

type InventoryReport struct {
	ProductCount   int
	AvailableStock int
	TotalAmount    float64
}

func GetInventoryReport() InventoryReport {
	reportChannel := make(chan InventoryReport)

	go func() {
		var report InventoryReport

		for _, p := range productList {
			report.ProductCount++
			report.AvailableStock += p.Stock
			report.TotalAmount += float64(p.Stock) * p.UnitPrice
		}

		reportChannel <- report
	}()

	finalReport := <-reportChannel
	return finalReport
}

func main() {
	fmt.Println("Welcome to Inventory Management System")

	err := AddProduct(Product{101, "Wireless Mouse", 25, 450})
	if err != nil {
		fmt.Println(err)
	}

	err = AddProduct(Product{102, "Mechanical Keyboard", 15, 1500})
	if err != nil {
		fmt.Println(err)
	}

	err = AddProduct(Product{103, "USB Cable", 40, 200})
	if err != nil {
		fmt.Println(err)
	}

	ShowProducts()

	fmt.Println("\nUpdating Wireless Mouse...")
	err = UpdateProduct(101, 30, 500)
	if err != nil {
		fmt.Println("Error:", err)
	}

	fmt.Println("\nDeleting USB Cable...")
	err = DeleteProduct(103)
	if err != nil {
		fmt.Println("Error:", err)
	}

	ShowProducts()

	summary := GetInventoryReport()

	fmt.Println("\n Inventory Summary ")
	fmt.Println("Number of Products:", summary.ProductCount)
	fmt.Println("Total Available Stock:", summary.AvailableStock)
	fmt.Printf("Total Inventory Value: Rs. %.2f\n", summary.TotalAmount)
}
