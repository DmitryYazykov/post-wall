//data-класс для хранения информации о посте
data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int?,
    val data: Int,
    val text: String?,
    val replyOwnerId: Int,
    val replayPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val postType: String,
    val geo : Geo?,
    val singerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdite: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val attachments: Array<Attachment>? = emptyArray(),
    val copyHistory: Array<Post>? = emptyArray()
)