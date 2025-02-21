package ru.yandex.practicum.dagger2_assisted.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.multibindings.IntoMap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.yandex.practicum.dagger2_assisted.FragmentNews


@Component
interface AppComponent {
    fun injectToNewsFragment(fragment:FragmentNews)
}
//@Module
//class SomeClassModule(){
//    @Provides
//    fun provideDispatchers(): CoroutineDispatcher = Dispatchers.IO
//}
//class SomeClass @AssistedInject constructor(
//    @Assisted id:Long,
//    dispatcher: CoroutineDispatcher
//)
//
//@AssistedFactory
//interface SomeClassFactory {
//    fun create(id: Long): SomeClass
//}


