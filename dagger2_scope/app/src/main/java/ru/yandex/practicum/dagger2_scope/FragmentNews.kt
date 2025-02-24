package ru.yandex.practicum.dagger2_scope

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.yandex.practicum.dagger2_scope.di.DaggerComponentNews
import javax.inject.Inject


class FragmentNews : Fragment() {
//    @Inject
//    lateinit var newsViewModelFactory: NewsViewModel.NewsViewModelFactory
//
//    private val newsViewModel: NewsViewModel by viewModels {
//        NewsViewModel.providesFactory(
//            assistedFactory = newsViewModelFactory,
//            userId = arguments?.getLong("USER_ID",0L) ?: 0L
//        )
//    }
    @Inject
    lateinit var remoteHostOne: RemoteHost

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appComponent = (requireContext().applicationContext as App).daggerAppComponent
        DaggerComponentNews.builder()
            .appComponent(appComponent)
            .build()
            .injectToFragmentNews(this)
    }
}