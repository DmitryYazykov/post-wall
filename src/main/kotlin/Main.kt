fun main() {
    val video = Video(
        123,
        12345,
        "Name video",
        "Text video",
        30,
        null,
        null,
        2022,
        2023,
        25,
        50,
        10,
        "Flash_player",
        "platform",
        true,
        true,
        "Key",
        false,
        false,
        true,
        false,
        true,
        true,
        true,
        true,
        false,
        150,
        350,
        123456789,
        true,
        false,
        true,
        1,
        "movie",
        0,
        "started",
        true,
        false,
        15,
        VideoLikes(50, true),
        VideoReposts(10, 15, 5, false)
    )
    val audio = Audio(
        12345,
        123456789,
        "Rammstein",
        "Mutter",
        268,
        "url",
        111,
        222,
        7,
        2023,
        1,
        1
    )
    val photo = Photo(
        12345,
        112233,
        123456789,
        100,
        "Text Photo",
        2023,
        arrayOf(Sizes("size", "url", 920, 1050)),
        920,
        1050
    )
    val graffiti = Graffiti(
        12345,
        123456789,
        "url_small",
        "url_big"
    )
    val note = Note(
        12345,
        123456789,
        "Title Note",
        "Text Note",
        2023,
        124,
        54,
        "url",
        "Privacy View",
        "Privacy Comment",
        true,
        "Wiki Text"
    )
    val attachmentVideo = VideoAttachment(video)
    val attachmentAudio = AudioAttachment(audio)
    val attachmentPhoto = PhotoAttachment(photo)
    val attachmentGraffiti = GraffitiAttachment(graffiti)
    val attachmentNote = NoteAttachment(note)

    val post1 = Post(
        111,
        12345,
        12345,
        null,
        2023,
        "Текст поста 1",
        12345,
        12345,
        false,
        Comments(canPost = false, groupCanPost = false, canClose = false, canOpen = false),
        Copyright(123, "Link1", "Name1", "Type1"),
        Likes(50, false, false, true),
        Reposts(100, true),
        Views(15),
        "Post",
        null,
        111,
        true,
        true,
        true,
        true,
        false,
        arrayOf(attachmentAudio, attachmentVideo),
        null
    )
    val post2 = Post(
        222,
        54321,
        54321,
        null,
        2022,
        "Текст поста 2",
        12345,
        12345,
        false,
        Comments(10, true, true, true, true),
        Copyright(123, "Link2", "Name2", "Type2"),
        Likes(userLikes = false, canLike = false, canPublish = false),
        Reposts(10, true),
        Views(25),
        "Copy",
        null,
        222,
        true,
        true,
        true,
        true,
        false,
        arrayOf(attachmentPhoto, attachmentGraffiti),
        null
    )
    val post3 = Post(
        333,
        67890,
        67890,
        null,
        2023,
        "Текст поста 3",
        12345,
        12345,
        true,
        Comments(10, true, true, true, true),
        Copyright(123, "Link3", "Name3", "Type3"),
        Likes(50, false, false, true),
        Reposts(userReposted = false),
        Views(35),
        "Reply",
        null,
        333,
        true,
        true,
        true,
        true,
        false,
        arrayOf(attachmentNote),
        null
    )

    //пост для нахождения и обновления поста с таким же id
    val post4 = Post(
        2,
        8888,
        8888,
        8888,
        8888,
        null,
        8888,
        8888,
        true,
        Comments(8888, true, true, true, true),
        Copyright(8888, "xxx", "xxx", "xxx"),
        Likes(8888, false, false, true),
        Reposts(8888, true),
        Views(8888),
        "Postpone",
        null,
        8888,
        false,
        true,
        true,
        false,
        false,
        null,
        null
    )

    //добавление постов в WallService и вывод результата
    println(WallService.add(post1))
    println(WallService.add(post2))
    println(WallService.add(post3))

    //обновление поста и вывод результата
    println(WallService.update(post4))

    val comment = Comment(
        12345,
        2,
        12345678,
        2023,
        "Текст комментария",
        null,
        12345,
        12345,
        arrayOf(attachmentAudio),
        null,
        null
    )

    try {
        WallService.createComment(comment)
    } catch (e: PostNotFoundException) {
        println(e.message)
    }
}