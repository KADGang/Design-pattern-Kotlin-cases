class OggComression {
    fun loadOggFile(filename: String) {
        println("Loading Ogg Files...($filename)")
    }
}

class MPEG4CompressionCodec {
    fun playMPEG4(filename: String) {
        println("Playing MPEG4 Files...($filename)")
    }
}

class VideoConverter {
    fun convertVideo(filename: String, format: String) {
        if (format == "ogg") {
            val oggComression = OggComression()
            oggComression.loadOggFile(filename)
        } else if (format == "mpeg4"){
            val mpeg4CompressionCodec = MPEG4CompressionCodec()
            mpeg4CompressionCodec.playMPEG4(filename)
        } else {
            println("Format not supported...")
        }
    }
}

fun main() {
    val videoConverter = VideoConverter()
    videoConverter.convertVideo("MPEG4file1", "mpeg4")
    videoConverter.convertVideo("Oggfile1", "ogg")
    videoConverter.convertVideo("flvfile1", "flv")
}