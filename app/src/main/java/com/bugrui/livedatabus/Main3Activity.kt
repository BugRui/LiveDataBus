package com.bugrui.livedatabus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bugrui.buslib.LiveDataBus
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        button.setOnClickListener {
            LiveDataBus.sendStickiness(10086, "10086")
        }
    }
}
