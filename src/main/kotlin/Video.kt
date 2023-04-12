//data-класс для хранения информации о видео
data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: Array<Image>? = emptyArray<Image>(),        //Изображение обложки
    val firstFrame: Array<Image>? = emptyArray<Image>(),   //Изображение первого кадра
    val date: Int,
    val addingDate: Int,
    val views: Int,
    val localViews: Int,
    val comments: Int,
    val player: String,
    val platform: String,
    val canAdd: Boolean,
    val isPrivate: Boolean = true,
    val accessKey: String,
    val processing: Boolean,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val canEdit: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val canAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribed: Boolean,
    val repeat: Int = 1,
    val type: String,
    val balance: Int,
    val liveStatus: String,
    val live: Boolean,
    val upcoming: Boolean,
    val spectators: Int,
    val likes: VideoLikes,
    val reposts: VideoReposts
)

//класс для хранения вложений видео
class VideoAttachment(param: Video) : Attachment {
    override val type: String = "video"
    val video = param

    override fun toString(): String {
        return "\n  $video"
    }
}

//data-класс содержащий поля для массивов Image и FirstFrame из видео
data class Image(
    val height: Int,
    val url: String,
    val width: Int,
    val withPadding: Int = 1     //Поле возвращается, если изображение с отбивкой, всегда содержит 1.
)

//data-класс содержащий поля для лайков из видео
data class VideoLikes(
    val count: Int,
    val userLikes: Boolean
)

//data-класс содержащий поля для репостов из видео
data class VideoReposts(
    val count: Int,
    val wallCount: Int,
    val MailCount: Int,
    val userReposted: Boolean
)