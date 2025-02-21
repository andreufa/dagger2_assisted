package ru.yandex.practicum.dagger2



import javax.inject.Inject
import dagger.Lazy
import javax.inject.Provider


class Bicycle @Inject constructor(private val frameProvider: Lazy<BicycleFrame>){
    fun getFrame():BicycleFrame{
        val frame = frameProvider.get()
        frame.buildFrame()
        return frame
    }
}
