package hr.ferit.igorkuridza.factorynewsreader.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.ferit.igorkuridza.factorynewsreader.model.News

@Database (entities = [News::class], version = 1, exportSchema = false)
abstract class DaoProvider: RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        private var instance: DaoProvider? = null

        fun getInstance(context: Context): DaoProvider{
            if(instance==null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DaoProvider::class.java,
                    "NewsDB"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as DaoProvider
        }
    }
}