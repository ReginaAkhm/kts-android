package com.kts_android.strava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreateView ${hashCode()}")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}