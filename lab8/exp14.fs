module Exp14

open System

[<AbstractClass>]
type Shape() =
    abstract member Area: unit -> float

type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        Math.PI * radius * radius

type Rectangle(length: float, width: float) =
    inherit Shape()

    override this.Area() =
        length * width

let circle = Circle(5.0)
let rectangle = Rectangle(10.0, 4.0)

let shapes: Shape list =
    [
        circle :> Shape
        rectangle :> Shape
    ]

printfn "Areas of Shapes:"

shapes
|> List.iter (fun shape ->
    printfn "Area = %.2f" (shape.Area())
)
