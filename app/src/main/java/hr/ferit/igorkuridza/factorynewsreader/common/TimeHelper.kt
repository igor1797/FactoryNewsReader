package hr.ferit.igorkuridza.factorynewsreader.common

import java.util.*

fun dataOlderThanFiveMinutes(pastTime: Long): Boolean{
    val currentTime = Calendar.getInstance().timeInMillis
    if((currentTime - pastTime)>300000) return true
    return false
}