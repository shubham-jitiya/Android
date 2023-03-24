package LearnKotlin.delegation

class FileDownloader(private val fileName: String) : Downloader {
    override fun download() {
        println("$fileName Downloaded")
    }
}

class FilePlayer(private val fileName: String) : Player {
    override fun play() {
        println("$fileName is playing")
    }
}

class MediaFile(private val downloader: Downloader, private val player: Player) :
    Downloader by downloader, Player by player

fun main() {
    val file: String = "KotlinPractice.mp4"
    val mediaFile = MediaFile(FileDownloader(file), FilePlayer(file))
    mediaFile.download()
    mediaFile.play()
}