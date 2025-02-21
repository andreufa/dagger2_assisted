package ru.yandex.practicum.dagger2_assisted

import javax.inject.Inject

class NewsRepository @Inject constructor(){
    fun fetchNews(userId:Long):List<News>{
        return emptyList()
    }
}

class News(
    val title:String
)