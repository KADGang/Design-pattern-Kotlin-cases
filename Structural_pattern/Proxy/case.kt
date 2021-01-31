interface ThirdPartyTVLib {
    fun listVideos(): String
    fun getVideoInfo(id: Int)
    fun downloadVideo(id: Int)
}

class CachedTVClass(service: ThirdPartyTVLib): ThirdPartyTVLib {
    private val downloadService: ThirdPartyTVLib = service
    private val cachedVideoList: Array<Int?> = arrayOfNulls(10)
    private var listCache: String? = null

    override fun listVideos(): String {
        if (listCache == null)
            listCache = downloadService.listVideos()
        return listCache as String
    }

    override fun getVideoInfo(id: Int) {
        for (cachedID in cachedVideoList) {
            if (cachedID == id) {
                println("Video has been cached")
                return
            }
        }
        downloadService.getVideoInfo(id)
    }

    override fun downloadVideo(id: Int) {
        for (cachedID in cachedVideoList) {
            if (cachedID == id) {
                println("Video has been cached")
                return
            }
        }
        downloadService.downloadVideo(id)
        for (i in 9 downTo 1)
            cachedVideoList[i] = cachedVideoList[i - 1]
        cachedVideoList[0] = id
    }
}

class ThirdPartyTVClass : ThirdPartyTVLib {
    override fun listVideos(): String {
        return "lists"
    }

    override fun getVideoInfo(id: Int) {
        println("Getting video information...(id: $id)")
    }

    override fun downloadVideo(id: Int) {
        println("Downloading video...(id: $id)")
    }
}

fun main() {
    val aTVService: ThirdPartyTVClass = ThirdPartyTVClass()
    val aTVProxy: CachedTVClass = CachedTVClass(aTVService)

    aTVProxy.getVideoInfo(12)
    aTVProxy.downloadVideo(12)

    aTVProxy.getVideoInfo(13)
    aTVProxy.downloadVideo(13)

    aTVProxy.getVideoInfo(12)
    aTVProxy.downloadVideo(12)
}