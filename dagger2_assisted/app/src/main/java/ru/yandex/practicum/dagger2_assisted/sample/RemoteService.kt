package ru.yandex.practicum.dagger2_assisted.sample

import android.content.ContentValues.TAG
import android.util.Log
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemoteService @AssistedInject constructor(
    @Assisted port: Int
) {
    init {
        Log.i(TAG,"RemoteService port: $port")
    }
}
@AssistedFactory
interface RemoteServiceFactory {
    fun create(port: Int): RemoteService
}



