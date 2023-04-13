//data-класс для хранения информации о фотографии
data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<Sizes> = emptyArray(),      //Изображение в разных размерах
    val width: Int,
    val height: Int
)

//класс для хранения вложений фотографии
class PhotoAttachment(param: Photo) : Attachment {
    override val type: String = "photo"
    val photo = param

    override fun toString(): String {
        return "\n  $photo"
    }
}

//data-класс содержащий поля для массива Sizes из фотографий
data class Sizes(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)