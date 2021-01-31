interface DataSource {
    fun writeData(data: String)
    fun readData(): String
}

class FileDataSource(fileName: String): DataSource {
    private var content: String = ""
    private var filename: String = fileName

    override fun writeData(data: String) {
        content = data
    }

    override fun readData(): String {
        return content
    }
}

open class DataSourceDecorator(s: DataSource): DataSource {
    protected val wrappee: DataSource = s

    override fun writeData(data: String) {
        wrappee.writeData(data)
    }

    override fun readData(): String {
        return wrappee.readData()
    }
}

class EncryptionDecorator(s: DataSource) : DataSourceDecorator(s) {
    init {
        writeData(wrappee.readData() + " 已被加密")
    }
}

class CompressionDecorator(s: DataSource) : DataSourceDecorator(s) {
    init {
        writeData(wrappee.readData() + " 已被压缩")
    }
}

fun main() {
    var file: DataSource = FileDataSource("文件1")
    file.writeData("这是文件1的内容")
    println(file.readData())

    file = EncryptionDecorator(file)
    println(file.readData())

    file = CompressionDecorator(file)
    println(file.readData())
}