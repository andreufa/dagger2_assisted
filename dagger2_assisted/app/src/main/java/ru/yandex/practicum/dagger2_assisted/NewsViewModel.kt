package ru.yandex.practicum.dagger2_assisted

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel @AssistedInject constructor(
    private val newsRepository: NewsRepository,
    @Assisted
    private val userId: Long
) : ViewModel() {
    private val _news = MutableStateFlow<List<News>>(emptyList())

    init {
        Log.i(TAG,"NewsViewModel USER_ID: $userId ")
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.fetchNews(userId)
        }
    }

    @AssistedFactory
    interface NewsViewModelFactory {
        fun create(userId: Long): NewsViewModel
    }

    companion object {
        fun providesFactory(
            assistedFactory: NewsViewModelFactory,
            userId: Long
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(userId) as T
            }
        }
    }
}