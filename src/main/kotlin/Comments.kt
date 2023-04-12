//data-класс для хранения информации о комментариях к посту
data class Comments(
    val count: Int = 0,
    val canPost: Boolean,
    val groupCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)