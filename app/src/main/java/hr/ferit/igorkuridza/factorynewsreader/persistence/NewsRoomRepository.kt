package hr.ferit.igorkuridza.factorynewsreader.persistence

import hr.ferit.igorkuridza.factorynewsreader.FactoryNewsReaderApp
import hr.ferit.igorkuridza.factorynewsreader.database.DaoProvider
import hr.ferit.igorkuridza.factorynewsreader.database.NewsDao
import hr.ferit.igorkuridza.factorynewsreader.model.News

class NewsRoomRepository: NewsRepository {
    private var db: DaoProvider = DaoProvider.getInstance(FactoryNewsReaderApp.getAppContext())

    private var newsDao: NewsDao = db.newsDao()

    override fun addSingleNews(news: News) {
        newsDao.addSingleNews(news)
    }

    override fun clearAllNews() {
        newsDao.clearAllNews()
    }

    override fun getNews(): List<News> {
        return newsDao.getAllNews()
    }
}