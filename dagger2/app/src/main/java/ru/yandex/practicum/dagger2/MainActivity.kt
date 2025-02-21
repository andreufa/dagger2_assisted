package ru.yandex.practicum.dagger2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.yandex.practicum.dagger2.ui.DaggerAppComponent
import ru.yandex.practicum.dagger2.ui.HomeHost


import ru.yandex.practicum.dagger2.ui.theme.Dagger2Theme
import javax.inject.Inject
import javax.inject.Named

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var game: Game

    @Inject
    lateinit var remoteHosts:Map<String, RemoteHost>


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.create().injectToMainActivity(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dagger2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        game.startGame()

                        remoteHosts.forEach {
                            Text(text = "${it.value.host} : ${it.value.port}")
                        }
                    }
                }
            }
        }
    }
}

