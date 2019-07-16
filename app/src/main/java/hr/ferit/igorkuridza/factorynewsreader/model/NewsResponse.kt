package hr.ferit.igorkuridza.factorynewsreader.model

import com.google.gson.annotations.SerializedName

class NewsResponse(@SerializedName ("articles") val news: ArrayList<News>)