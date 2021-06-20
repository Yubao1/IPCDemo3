package com.xe.demo.ipcservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.xe.demo.ipcdemo3.ICommunicationManager

/**
 * Created by 86188 on 2021/6/16.
 */
class AIDLService: Service() {
    var TAG: String = "AIDLService"
    var mBinder: Binder? = null
    override fun onBind(intent: Intent?): IBinder {
        return mBinder!!
    }

    override fun onCreate() {
        super.onCreate()
        initBinder()
    }

    fun initBinder() {
        mBinder = ImplCommunicationManager()
    }

    inner class ImplCommunicationManager: ICommunicationManager.Stub() {
        override fun basicTypes(anInt: Int, aLong: Long, aBoolean: Boolean, aFloat: Float, aDouble: Double, aString: String?) {
        }

        override fun sendMessage(msg: String?) {
            Log.d(TAG,msg)
        }

    }
}