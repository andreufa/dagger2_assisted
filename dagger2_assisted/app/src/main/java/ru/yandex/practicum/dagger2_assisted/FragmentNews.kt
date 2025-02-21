package ru.yandex.practicum.dagger2_assisted

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.yandex.practicum.dagger2_assisted.di.DaggerAppComponent
import ru.yandex.practicum.dagger2_assisted.sample.RemoteServiceFactory

import javax.inject.Inject

class FragmentNews : Fragment(R.layout.fragment_news) {

    @Inject
    lateinit var newsViewModelFactory: NewsViewModel.NewsViewModelFactory

    private val viewModel: NewsViewModel by viewModels {
        NewsViewModel.providesFactory(
            assistedFactory = newsViewModelFactory,
            userId = arguments?.getLong("USER_ID") ?: 0L
        )
    }
    @Inject
    lateinit var remoteServiceFactory: RemoteServiceFactory



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerAppComponent.create().injectToNewsFragment(this)
        viewModel.hashCode()
        val remoteService = remoteServiceFactory.create(arguments?.getInt("PORT") ?: 0)
    }
}