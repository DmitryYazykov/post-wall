fun main() {
    val post1 = Post(
        111,
        12345,
        12345,
        12345,
        2021,
        "Текст поста 1",
        12345,
        12345,
        false,
        Comments(canPost = false, groupCanPost = false, canClose = false, canOpen = false),
        Likes(50, false, false, true),
        Reposts(100, true)
    )
    val post2 = Post(
        222,
        54321,
        54321,
        54321,
        2022,
        "Текст поста 2",
        12345,
        12345,
        false,
        Comments(10, true, true, true, true),
        Likes(userLikes = false, canLike = false, canPublish = false),
        Reposts(10, true)
    )
    val post3 = Post(
        333,
        67890,
        67890,
        67890,
        2023,
        "Текст поста 3",
        12345,
        12345,
        true,

        Comments(10, true, true, true, true),
        Likes(50, false, false, true),
        Reposts(userReposted = false)
    )

    //пост для нахождения и обновления поста с таким же id
    val post4 = Post(
        3,
        8888,
        8888,
        8888,
        8888,
        "Текст поста 4",
        8888,
        8888,
        true,

        Comments(8888, true, true, true, true),
        Likes(8888, false, false, true),
        Reposts(8888, true)
    )

    //добавление постов в WallService и вывод результата
    println(WallService.add(post1))
    println(WallService.add(post2))
    println(WallService.add(post3))

    //обновление поста и вывод результата
    println(WallService.update(post4))
}

//data-класс для хранения информации о посте
data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val data: Int,
    val text: String,
    val replyOwnerId: Int,
    val replayPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val likes: Likes,
    val reposts: Reposts
)

//data-класс для хранения информации о комментариях к посту
data class Comments(
    val count: Int = 0,
    val canPost: Boolean,
    val groupCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

//data-класс для хранения информации о лайках к посту
data class Likes(
    val count: Int = 0,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

//data-класс для хранения информации о репостах поста
data class Reposts(
    val count: Int = 0,
    val userReposted: Boolean
)

//объект для хранения постов в массиве и работы с ними
object WallService {
    private var posts: Array<Post> = emptyArray()
    private var nextId: Int = 1

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
}