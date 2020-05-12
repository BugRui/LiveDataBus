package com.bugrui.livedatabus

import android.content.Intent
import android.os.Bundle
import android.util.Log

import com.bugrui.buslib.LiveDataBus
import com.google.android.material.floatingactionbutton.FloatingActionButton

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.content_main2.*
import java.sql.DriverManager


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            startActivity(Intent(this@Main2Activity, Main3Activity::class.java))
            finish()
        }

        button2.setOnClickListener {
            LiveDataBus.send(10010)
        }

        LiveDataBus.with(10020)
                .observeForever(this, Observer {
                    Log.e("bugrui","Main2Activity收到一条普通事件消息")
                })
        LiveDataBus.withStickiness(10086)
                .observeForever(this, Observer {
                    Log.e("bugrui","Main2Activity收到一条粘性事件消息")
                })
    }

}


