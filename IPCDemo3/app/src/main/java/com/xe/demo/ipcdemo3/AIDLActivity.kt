package com.xe.demo.ipcdemo3

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.view.View
import com.xe.demo.ipcservice.AIDLService

class AIDLActivity : AppCompatActivity() {
    var mServiceConnection: ServiceConnection? = null
    var mICommunicationManager: ICommunicationManager? = null
    var num: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidl)
        initServiceConnection()
    }

    fun initServiceConnection() {
        mServiceConnection = MyServiceConnection();
    }

    fun onClick(v: View) {
        if (v.id == R.id.btn_1) {
           bindService()
        } else if (v.id == R.id.btn_2) {
            sendMessage()
        }
    }

    fun sendMessage() {
        var msg = "从客户端发送" + num + "条消息给服务端"
        num++
        try {
            mICommunicationManager!!.sendMessage(msg)
        } catch (e: RemoteException) {

        }
    }

    fun bindService() {
        var intent: Intent = Intent(this, AIDLService::class.java)
        bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE)
    }

    inner class MyServiceConnection: ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mICommunicationManager = ICommunicationManager.Stub.asInterface(service)
        }


        override fun onServiceDisconnected(name: ComponentName?) {

        }

    }
}
