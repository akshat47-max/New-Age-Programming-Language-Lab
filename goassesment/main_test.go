package main

import "testing"

func clearProducts() {
	productList = []Product{}
}

func TestAddProduct(t *testing.T) {
	clearProducts()

	newProduct := Product{101, "Laptop Stand", 10, 800}

	err := AddProduct(newProduct)

	if err != nil {
		t.Errorf("Unable to add product: %v", err)
	}

	if len(productList) != 1 {
		t.Errorf("Expected 1 product, got %d", len(productList))
	}
}

func TestUpdateProduct(t *testing.T) {
	clearProducts()

	AddProduct(Product{102, "Headphones", 10, 1000})

	err := UpdateProduct(102, 20, 1200)

	if err != nil {
		t.Errorf("Update failed: %v", err)
	}

	if productList[0].Stock != 20 {
		t.Error("Stock was not updated correctly")
	}
}

func TestDeleteProduct(t *testing.T) {
	clearProducts()

	AddProduct(Product{103, "USB Hub", 15, 600})

	err := DeleteProduct(103)

	if err != nil {
		t.Errorf("Delete failed: %v", err)
	}

	if len(productList) != 0 {
		t.Error("Product was not deleted")
	}
}

func TestDuplicateProduct(t *testing.T) {
	clearProducts()

	AddProduct(Product{104, "Keyboard", 10, 900})

	err := AddProduct(Product{104, "Keyboard", 10, 900})

	if err == nil {
		t.Error("Duplicate product should not be allowed")
	}
}

func TestInvalidProduct(t *testing.T) {
	clearProducts()

	err := AddProduct(Product{105, "", 10, 500})

	if err == nil {
		t.Error("Empty product name should return the error")
	}
}
