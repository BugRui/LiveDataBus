package com.bugrui.livedatabus

import android.os.Bundle

import com.bugrui.buslib.LiveDataBus
import com.google.android.material.floatingactionbutton.FloatingActionButton

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            LiveDataBus.send(10010, "10010")
            finish()
        }

        LiveDataBus.withStickiness(10086)
                .observe(this, Observer {
                    toast("收到粘性事件消息：${it.toString()}")
                })

    }

}


