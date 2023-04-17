//объект для хранения постов в массиве и работы с ними
object WallService {
    private var posts: Array<Post> = emptyArray()
    private var nextId: Int = 1

    private var comments = emptyArray<Comment>()

    //метод для создания записи
    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId)
        posts += newPost
        nextId += 1
        return posts.last()
    }

    //метод для нахождения и обновления поста по id
    fun update(post: Post): Boolean {
        for ((index, mess) in posts.withIndex()) {
            if (mess.id == post.id) {
                posts[index] = post.copy(ownerId = post.ownerId, data = post.data)
                println("\nПост c id:${post.id} обновлён.\n$post")
                return true
            }
        }
        return false
    }

    //метод для комментирования
    fun createComment(comment: Comment): Boolean {
        for (post in posts) {
            if (comment.postId == post.id) {
                comments += comment
                println("\n $comment")
                return true
            }
        }
        throw PostNotFoundException("\nПост не найден.")
    }

    //метод для сброса значений
    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
        nextId = 1
    }
}