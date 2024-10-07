package com.stver8935.riding.ui

import NetworkDetector
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import com.stver8935.riding.R
import com.stver8935.riding.domain.network.NetworkStateListener

/**
 *
 *
 * @packageName    : com.stver8935.riding.ui
 * @fileName   : BaseActivity
 * @author     : hangihyeong
 * @since      : 2024. 10. 1.
 */
open class BaseActivity: ComponentActivity(),NetworkStateListener {
    private var backPressdTime: Long = 0
    private val BACK_PRESSED_TIMEOUT: Short  = 1000
    private lateinit var networkDetector: NetworkDetector
    private val TAG = this::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        networkDetector.unRegisterCallback()
    }

    fun init(){
        networkDetector = NetworkDetector(this)
        networkDetector.registerCallback(this)
        initBackPressed()
    }

    open fun initBackPressed(){
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(System.currentTimeMillis() - backPressdTime >= BACK_PRESSED_TIMEOUT)
                {
                    val msg: String = resources.getString(R.string.toast_msg_back_pressed_close_app)
                    Toast.makeText(this@BaseActivity,msg,Toast.LENGTH_LONG).show()
                    backPressdTime = System.currentTimeMillis()
                }
                else
                {
                    finishAffinity()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this,onBackPressedCallback)
    }


    override fun onAvailableNetwork() {
    }

    override fun onLostNetwork() {

    }

    override fun onLosing() {

    }

    override fun onLost() {
    }

    override fun onUnavailable() {
    }
}

