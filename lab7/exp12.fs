module Exp12

// List.map - Square each element
let numbers1 = [1; 2; 3; 4; 5]
let numbers2 = [2; 4; 6; 8]

let squares1 = List.map (fun x -> x * x) numbers1
let squares2 = List.map (fun x -> x * x) numbers2

printfn "List.map:"
printfn "Original: %A" numbers1
printfn "Squares: %A" squares1
printfn "Original: %A" numbers2
printfn "Squares: %A" squares2


// List.filter - Select even numbers
let numbers3 = [1; 2; 3; 4; 5; 6]
let numbers4 = [10; 15; 20; 25; 30]

let even1 = List.filter (fun x -> x % 2 = 0) numbers3
let even2 = List.filter (fun x -> x % 2 = 0) numbers4

printfn "\nList.filter:"
printfn "Original: %A" numbers3
printfn "Even numbers: %A" even1
printfn "Original: %A" numbers4
printfn "Even numbers: %A" even2


// List.fold - Calculate sum
let numbers5 = [1; 2; 3; 4; 5]
let numbers6 = [10; 20; 30; 40]

let sum1 = List.fold (fun acc x -> acc + x) 0 numbers5
let sum2 = List.fold (fun acc x -> acc + x) 0 numbers6

printfn "\nList.fold:"
printfn "List: %A" numbers5
printfn "Sum: %d" sum1
printfn "List: %A" numbers6
printfn "Sum: %d" sum2
