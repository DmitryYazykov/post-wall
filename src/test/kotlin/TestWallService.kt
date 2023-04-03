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

    //тест изменяет пост с существующим id, возвращается true
    @Test
    fun updateExisting() {
        val service = WallService
        val post1 = Post(111,
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
        val update = Post(
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
        service.add(post1)
        service.add(post2)
        service.add(post3)
        val result = service.update(update)
        assertTrue(result)
    }
    //тест изменяет пост с несуществующим id, возвращается false
    @Test
    fun updateNotExisting() {
        val service = WallService
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
        val update = Post(
            123,
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
        service.add(post1)
        service.add(post2)
        service.add(post3)
        val result = service.update(update)
        assertFalse(result)
    }
}