//data-класс для хранения информации об аудиозаписи
data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Int,
    val isHq: Int,
)

//класс для хранения вложения аудиозаписи
class AudioAttachment(param: Audio) : Attachment {
    override val type: String = "audio"
    val audio = param

    override fun toString(): String {
        return "\n  $audio"
    }
}