package com.codewithdivya.kmmapplication.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openGrains(v: View?) {
        val intent = Intent(this, MultiGrainActivity::class.java)
        startActivity(intent)
    }
}