object Database {
    var databaseName : String = ""

    public fun getInstance(name: String) : Database {
        databaseName = name
        return Database
    }
}

fun main() {
    val database1: Database = Database.getInstance("base1")
    println(database1.databaseName)
    val database2: Database = Database.getInstance("base2")
    println(database2.databaseName)
    println(database1.databaseName)
}