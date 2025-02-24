package ru.yandex.practicum.dagger2_scope.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import ru.yandex.practicum.dagger2_scope.FragmentNews
import ru.yandex.practicum.dagger2_scope.MainActivity
import ru.yandex.practicum.dagger2_scope.RemoteHost
import javax.inject.Qualifier
import javax.inject.Scope
import javax.inject.Singleton


@Singleton
@Component(modules = [ModuleRemoteHost::class])
interface AppComponent {
   fun injectToMainActivity(activity: MainActivity)
}


@Module
class ModuleRemoteHost {
    @Singleton
    @Provides
    fun provideRemoteHostA() = RemoteHost(host = "ru.example.a", port = 24011)
}

@FeatureNews
@Component(
    modules = [ModuleNews ::class],
    dependencies = [AppComponent::class]
)
interface ComponentNews {
    fun inject(activity: MainActivity)
    fun injectToFragmentNews(fragment: FragmentNews)
}

@Module
class ModuleNews {
    @FeatureNews
    @Provides
    fun provideRemoteHostNews() = RemoteHost(host = "ru.example.news", port = 39000)
}


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureNews

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkHost