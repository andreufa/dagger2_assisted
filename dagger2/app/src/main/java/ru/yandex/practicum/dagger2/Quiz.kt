package ru.yandex.practicum.dagger2

import javax.inject.Inject
import dagger.Lazy
import dagger.Provides
import javax.inject.Provider

class Questions @Inject constructor(){
    val items = listOf("Первый вопрос", "Второй вопрос")
}
class Quiz @Inject constructor(private val questionsProvider: Lazy<Questions>) {
    fun getQuestion():List<String>{
        return questionsProvider.get().items
    }
}

class Game @Inject constructor(private val quizProvider: Provider<Quiz>){
    fun startGame(){
        quizProvider.get().getQuestion()
    }
}
