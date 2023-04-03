import org.junit.Test

import org.junit.Assert.*

class TestWallService {

    //тест проверяет, что после добавления поста id стал отличным от 0
    @Test
    fun add() {
        val service = WallService
        val newPost = service.add(Post(
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
        ))
        assertTrue(newPost.id > 0)
    }
}