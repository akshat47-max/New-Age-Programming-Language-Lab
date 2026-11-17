
type Book(id: int, name: string, author: string, issued: bool) =
    member this.Id = id
    member this.Name = name
    member this.Author = author
    member this.Issued = issued

type Library() =

    let mutable books: Book list = []

    member this.AddBook(book: Book) =
        books <- books @ [book]
        printfn "Book added: %s" book.Name

    member this.ShowBooks() =
        books |> List.iter (fun b ->
            let status =
                match b.Issued with
                | true -> "Issued"
                | false -> "Available"

            printfn "%s by %s - %s" b.Name b.Author status
        )

    member this.AvailableBooks() =
        books
        |> List.filter (fun b -> not b.Issued)
        |> List.map (fun b -> b.Name)

[<EntryPoint>]
let main argv =

    let library = Library()

    library.AddBook(Book(1, "Atomic Habits", "James Clear", false))
    library.AddBook(Book(2, "Clean Code", "Robert Martin", true))
    library.AddBook(Book(3, "The Alchemist", "Paulo Coelho", false))

    printfn "\nAll Books:"
    library.ShowBooks()

    printfn "\nAvailable Books:"
    library.AvailableBooks()
    |> List.iter (printfn "%s")

    0
