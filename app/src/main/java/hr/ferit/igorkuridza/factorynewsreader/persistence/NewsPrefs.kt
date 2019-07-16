package hr.ferit.igorkuridza.factorynewsreader.persistence

import android.content.Context
import hr.ferit.igorkuridza.factorynewsreader.FactoryNewsReaderApp

const val PREFS_NAME = "newsPrefs"
const val PREFS_KEY = "time"

object NewsPrefs {

    private fun sharedPrefs() = FactoryNewsReaderApp.instance.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun storeTime(key: String, value: Long){
        val editor = sharedPrefs().edit()
        editor.putLong(key, value).apply()
    }

    fun getTime(key: String, defaultValue: Long): Long? {
        return sharedPrefs().getLong(key, defaultValue)
    }
}