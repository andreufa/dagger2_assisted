package ru.yandex.practicum.dagger2_assisted

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fragment = FragmentNews().apply {
            setArguments(bundleOf(
                "PORT" to 12000,
                "USER_ID" to 101L
            ))
        }
        supportFragmentManager.commit {
            replace(R.id.fragment_container_view, fragment)
        }
    }
}