#r "nuget: MongoDB.Driver, 2.25.0"

open MongoDB.Bson
open MongoDB.Driver

type Student =
    {
        Id: ObjectId
        Name: string
        Age: int
    }

let client = MongoClient("mongodb://localhost:27017")

let database = client.GetDatabase("CollegeDB")

let collection =
    database.GetCollection<Student>("Students")

collection.DeleteMany(Builders<Student>.Filter.Empty).DeletedCount
|> ignore

let student1 =
    {
        Id = ObjectId.GenerateNewId()
        Name = "Akshat"
        Age = 21
    }

let student2 =
    {
        Id = ObjectId.GenerateNewId()
        Name = "Rahul"
        Age = 22
    }

collection.InsertOne(student1)
collection.InsertOne(student2)

printfn "After CREATE:"

collection.Find(Builders<Student>.Filter.Empty).ToList()
|> Seq.iter (fun student ->
    printfn "Name: %s, Age: %d" student.Name student.Age
)

printfn "\nREAD:"

collection.Find(Builders<Student>.Filter.Empty).ToList()
|> Seq.iter (fun student ->
    printfn "Name: %s, Age: %d" student.Name student.Age
)

let update =
    Builders<Student>.Update.Set((fun x -> x.Age), 23)

collection.UpdateOne(
    Builders<Student>.Filter.Eq((fun x -> x.Name), "Akshat"),
    update
)
|> ignore

printfn "\nAfter UPDATE:"

collection.Find(Builders<Student>.Filter.Empty).ToList()
|> Seq.iter (fun student ->
    printfn "Name: %s, Age: %d" student.Name student.Age
)

collection.DeleteOne(
    Builders<Student>.Filter.Eq((fun x -> x.Name), "Rahul")
)
|> ignore

printfn "\nAfter DELETE:"

collection.Find(Builders<Student>.Filter.Empty).ToList()
|> Seq.iter (fun student ->
    printfn "Name: %s, Age: %d" student.Name student.Age
)
