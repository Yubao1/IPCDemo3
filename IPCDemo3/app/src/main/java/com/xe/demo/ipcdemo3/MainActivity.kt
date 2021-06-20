package com.xe.demo.ipcdemo3

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by 86188 on 2021/6/15.
 */
class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View) {
        if (v.id == R.id.btn_aidl) {
           var intent: Intent = Intent(this,AIDLActivity::class.java)
            startActivity(intent)
        }
    }
}