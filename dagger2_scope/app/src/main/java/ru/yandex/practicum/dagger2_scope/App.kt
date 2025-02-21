package ru.yandex.practicum.dagger2_scope

import android.app.Application
import ru.yandex.practicum.dagger2_scope.di.AppComponent
import ru.yandex.practicum.dagger2_scope.di.DaggerAppComponent

class App:Application() {
    lateinit var daggerAppComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerAppComponent.create()
    }
}