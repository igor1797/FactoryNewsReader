package hr.ferit.igorkuridza.factorynewsreader.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class News (
    @PrimaryKey
    @SerializedName("title") val newsTitle: String,
    @SerializedName("description") val newsDescription: String,
    @SerializedName("urlToImage") val newsImagePath: String
)