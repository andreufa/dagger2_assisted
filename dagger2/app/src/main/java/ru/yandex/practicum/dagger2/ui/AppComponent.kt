package ru.yandex.practicum.dagger2.ui

import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey
import ru.yandex.practicum.dagger2.MainActivity
import ru.yandex.practicum.dagger2.RemoteHost
import javax.inject.Qualifier


//enum class Remotes{
//    HOME,
//    WORK
//}
//
//@MapKey
//annotation class MyEnumKey(val value: Remotes)


@Component(modules = [ModuleA::class, ModuleB::class])
interface AppComponent {
    fun injectToMainActivity(activity: MainActivity)
}

//@Module
//class ModuleA {
//    @IntoMap
//    @StringKey("hostA")
//    @Provides
//    fun provideRemoteHostA() = RemoteHost(host = "ru.example.a", port = 24011)
//}
//@Module
//class ModuleB{
//    @IntoMap
//    @StringKey("hostB")
//    @Provides
//    fun provideRemoteHostB() = RemoteHost(host = "ru.example.b", port = 19001)
//}

@Module
class ModuleA {
    //Какую аннотцию необходимо добавить
    @Provides
    fun provideRemoteHostA() = RemoteHost(host = "ru.example.a", port = 24011)
}

@Module
class ModuleB{
    //Какую аннотцию необходимо добавить
    @Provides
    fun provideRemoteHostB() = RemoteHost(host = "ru.example.b", port = 19001)
}
//@Module
//class ModuleB {
//    @ElementsIntoSet
//    @Provides
//    fun provideRemoteHostB(): Set<RemoteHost> {
//        return setOf(
//            RemoteHost(host = "ru.example.b", port = 19001),
//            RemoteHost(host = "ru.example.c", port = 15000)
//        )
//    }
//}


@Module
class ProvideRemoteHost {

    @Provides
    @HomeHost
    fun provideHomeHost() = RemoteHost(host = "ru.example.home", port = 24011)

    @Provides
    @WorkHost
    fun provideWorkHost() = RemoteHost(host = "ru.example.work", port = 19001)
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class HomeHost

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkHost