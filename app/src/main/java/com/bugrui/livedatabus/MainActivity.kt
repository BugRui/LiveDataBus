package com.bugrui.livedatabus

import android.content.Intent
import android.os.Bundle
import android.util.Log

import com.bugrui.buslib.LiveDataBus
import com.google.android.material.floatingactionbutton.FloatingActionButton

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import java.sql.DriverManager.println

class MainActivity : AppCompatActivity() {

    private var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        fab = findViewById(R.id.fab)
        fab!!.setOnClickListener {
            startActivity(Intent(this@MainActivity, Main2Activity::class.java))
        }

        LiveDataBus.with(10010)
                .observeForever(this, Observer {
                    Log.e("bugrui","MainActivity收到一条普通事件消息")
                })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_settings) {
            LiveDataBus.sendStickiness(10086, "10086")
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
