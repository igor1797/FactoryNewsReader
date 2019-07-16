package hr.ferit.igorkuridza.factorynewsreader.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import hr.ferit.igorkuridza.factorynewsreader.model.News

@Dao
interface NewsDao {

    @Query("Select* FROM News")
    fun getAllNews(): List<News>

    @Query("Delete FROM News")
    fun clearAllNews()

    @Insert(onConflict = IGNORE)
    fun addSingleNews(news: News)
}