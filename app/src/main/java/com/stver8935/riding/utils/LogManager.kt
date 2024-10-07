package com.stver8935.riding.utils

import android.icu.util.Calendar
import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.LogStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import java.text.SimpleDateFormat
import java.util.Locale

object LogManager : LogStrategy {
    private const val DEF_TAG = "DEVELOPER"

    fun initialize() {
        configLogger()
    }

    private fun configLogger(){
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(2)
            .methodOffset(5)
            .logStrategy(this)
            .tag(DEF_TAG)
            .build()

        Logger.addLogAdapter(object: AndroidLogAdapter(formatStrategy){
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return super.isLoggable(priority, tag)
//                return BuildConfig.DEBUG
            }
        })
    }

    override fun log(priority: Int, tag: String?, message: String) {
        val logLevel = Level.fromInt(priority)
        val calendar = Calendar.getInstance()
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val formattedDate = format.format(calendar.time)

        Log.println(priority,tag?:DEF_TAG,message)

        if(Level.WARN.level <= logLevel?.level!!) {
            //formattedDate - TAG ( logLevel.name ) : message
        }
    }

    enum class Level(val level: Int){
        VERBOSE(level = 2),
        DEBUG(level = 3),
        INFO(level = 4),
        WARN(level = 5),
        ERROR(level = 6),
        ASSERT(level = 7);

        companion object{
            fun fromInt(level: Int): Level?{
                return entries.find { it.level == level }
            }
        }
    }
}