package ru.yandex.practicum.dagger2_scope

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.yandex.practicum.dagger2_scope.di.DaggerComponentNews


import ru.yandex.practicum.dagger2_scope.ui.theme.Dagger2_scopeTheme
import javax.inject.Inject
//(applicationContext as App).daggerAppComponent.injectToMainActivity(this)
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var newsViewModelFactory: NewsViewModel.NewsViewModelFactory
//
////    private val viewModel: NewsViewModel by viewModels {
////        NewsViewModel.providesFactory(
////            assistedFactory = newsViewModelFactory,
////            userId = args.userId
////        )
////    }

    @Inject
    lateinit var remoteHostOne: RemoteHost

    @Inject
    lateinit var remoteHostTwo: RemoteHost

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        val appComponent = (applicationContext as App).daggerAppComponent
        DaggerComponentNews.builder().appComponent(appComponent).build().inject(this)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Dagger2_scopeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "remoteHostOne: ${remoteHostOne.hashCode()}")
                        Text(text = "remoteHostTwo: ${remoteHostTwo.hashCode()}")
                    }
                }
            }
        }
    }
}



