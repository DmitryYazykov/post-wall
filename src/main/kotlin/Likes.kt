//data-класс для хранения информации о лайках к посту
data class Likes(
    val count: Int = 0,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)