//data-класс для хранения информации о заметке
data class Note(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int,
    val readComments: Int,
    val viewUrl: String,
    val privacyView: String,
    val privacyComment: String,
    val canComment: Boolean,
    val textWiki: String
)

//класс для хранения вложений о заметке
class NoteAttachment(param: Note) : Attachment {
    override val type: String = "note"
    private val note = param

    override fun toString(): String {
        return "\n  $note"
    }
}