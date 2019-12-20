package ru.nsu.geochat.modules.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.nsu.geochat.R

abstract class BaseActivity(val fragment: Fragment): AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .commit()

    }

    protected fun resetFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}