#r "nuget: Microsoft.Data.Sqlite, 8.0.0"

open Microsoft.Data.Sqlite

let connectionString = "Data Source=students.db"

use connection = new SqliteConnection(connectionString)
connection.Open()

let executeQuery query =
    use command = connection.CreateCommand()
    command.CommandText <- query
    command.ExecuteNonQuery() |> ignore

let printStudents () =
    use command = connection.CreateCommand()
    command.CommandText <- "SELECT Id, Name, Age FROM Student"

    use reader = command.ExecuteReader()

    printfn "\nCurrent Students:"

    while reader.Read() do
        printfn "Id: %d, Name: %s, Age: %d"
            (reader.GetInt32(0))
            (reader.GetString(1))
            (reader.GetInt32(2))

executeQuery "DROP TABLE IF EXISTS Student"

executeQuery """
CREATE TABLE Student (
    Id INTEGER PRIMARY KEY,
    Name TEXT,
    Age INTEGER
)
"""

executeQuery "INSERT INTO Student VALUES (1, 'Akshat', 21)"
executeQuery "INSERT INTO Student VALUES (2, 'Rahul', 22)"

printfn "After CREATE:"
printStudents()

printfn "\nREAD:"
printStudents()

executeQuery "UPDATE Student SET Age = 23 WHERE Id = 1"

printfn "\nAfter UPDATE:"
printStudents()

executeQuery "DELETE FROM Student WHERE Id = 2"

printfn "\nAfter DELETE:"
printStudents()

connection.Close()
