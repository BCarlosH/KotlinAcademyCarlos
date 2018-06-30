package com.example.carlos.kotlinacademycarlos.common

import com.example.carlos.kotlinacademycarlos.main.model.MediaItem

fun dummyMainListData(): List<MediaItem> {
    var list = mutableListOf<MediaItem>()

    list.add(MediaItem("Item 1", "http://i.imgur.com/DvpvklR.png"))
    list.add(MediaItem("Item 2", "https://i.pinimg.com/originals/33/bc/58/33bc58e0994707e35b05dbf9f89612f3.jpg"))
    list.add(MediaItem("Item 3", "http://www.pablo-ruiz-picasso.ru/images/works/217.jpg"))
    list.add(MediaItem("Item 4", "http://picassolive.ru/wp-content/uploads/2012/07/Pablo-Picasso_Harlequin-Musicien_1924.jpg"))
    list.add(MediaItem("Item 5", "http://i.imgur.com/DvpvklR.png"))
    list.add(MediaItem("Item 6", "https://i.pinimg.com/originals/33/bc/58/33bc58e0994707e35b05dbf9f89612f3.jpg"))
    list.add(MediaItem("Item 7", "http://www.pablo-ruiz-picasso.ru/images/works/217.jpg"))
    list.add(MediaItem("Item 8", "http://picassolive.ru/wp-content/uploads/2012/07/Pablo-Picasso_Harlequin-Musicien_1924.jpg"))

    return list
}

fun dummyAltMainListData(): List<MediaItem> {
    var list = mutableListOf<MediaItem>()

    list.add(MediaItem("Item 1", "https://www.optoma.es/images/ProductApplicationFeatures/4kuhd/banner.jpg"))
    list.add(MediaItem("Item 2", "https://i.pinimg.com/originals/33/bc/58/33bc58e0994707e35b05dbf9f89612f3.jpg"))
    list.add(MediaItem("Item 3", "https://tomdup.files.wordpress.com/2016/12/ultra-high-definition-4k-wallpapers.jpg"))
    list.add(MediaItem("Item 4", "http://picassolive.ru/wp-conttent/uploads/2012/07/Pablo-Picasso_Harlequin-Musicien_1924.jpg"))
    list.add(MediaItem("Item 5", "http://i.imgur.com/DvpvklR.png"))
    list.add(MediaItem("Item 6", "https://i.pinimg.com/originals/33/bc/58/33bc58e0994707e35b05dbf9f89612f3.jpg"))
    list.add(MediaItem("Item 7", "http://www.pablo-ruiz-picasso.ru/images/works/217.jpg"))
    list.add(MediaItem("Item 8", "http://picassolive.ru/wp-content/uploads/2012/07/Pablo-Picasso_Harlequin-Musicien_1924.jpg"))

    return list
}