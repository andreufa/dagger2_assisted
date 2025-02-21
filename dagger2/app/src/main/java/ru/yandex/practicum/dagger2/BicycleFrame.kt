package ru.yandex.practicum.dagger2

import java.util.UUID
import javax.inject.Inject

class BicycleFrame @Inject constructor(){
    private var number:Long? = null

    fun buildFrame():Long{
        //Создается рама и ей присваивается номер
        return number ?: 0L
    }
}