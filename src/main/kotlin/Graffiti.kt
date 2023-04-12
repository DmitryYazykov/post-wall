//data-класс для хранения информации о подарке
data class Graffiti(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)

//класс для хранения вложений о подарке
class GraffitiAttachment(param: Graffiti) : Attachment {
    override val type: String = "gift"
    val graffiti = param

    override fun toString(): String {
        return "\n  $graffiti"
    }
}