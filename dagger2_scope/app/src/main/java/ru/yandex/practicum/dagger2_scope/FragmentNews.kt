package ru.yandex.practicum.dagger2_scope

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import javax.inject.Inject


class FragmentNews : Fragment() {
    @Inject
    lateinit var newsViewModelFactory: NewsViewModel.NewsViewModelFactory

    private val newsViewModel: NewsViewModel by viewModels {
        NewsViewModel.providesFactory(
            assistedFactory = newsViewModelFactory,
            userId = arguments?.getLong("USER_ID",0L) ?: 0L
        )
    }
}