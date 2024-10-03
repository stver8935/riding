package com.stver8935.riding.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.stver8935.riding.R

/**
 *
 *
 * @packageName    : com.stver8935.riding.ui
 * @fileName   : BaseActivity
 * @author     : hangihyeong
 * @since      : 2024. 10. 1.
 */
open class BaseActivity: ComponentActivity() {
    private var backPressdTime: Long = 0
    private val BACK_PRESSED_TIMEOUT: Short  = 1000

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
    }

    fun init(){
        initBackPressed()
    }

    open fun initBackPressed(){
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(System.currentTimeMillis() - backPressdTime >= BACK_PRESSED_TIMEOUT)
                {
                    val msg: String = resources.getString(R.string.toast_msg_back_pressed_close_app);
                    Toast.makeText(this@BaseActivity,msg,Toast.LENGTH_LONG).show();
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



}

