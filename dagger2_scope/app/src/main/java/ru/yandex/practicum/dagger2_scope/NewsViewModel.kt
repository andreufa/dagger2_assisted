package ru.yandex.practicum.dagger2_scope

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
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
    val news: StateFlow<List<News>> = _news.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                newsRepository.fetchNews(userId)
            }.onSuccess {
                _news.value = it
            }.onFailure {
                Log.e(TAG, "${it.message}")
            }
        }
    }

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