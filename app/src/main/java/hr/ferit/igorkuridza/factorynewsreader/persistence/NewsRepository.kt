package hr.ferit.igorkuridza.factorynewsreader.persistence

import hr.ferit.igorkuridza.factorynewsreader.model.News

interface NewsRepository {
    fun addSingleNews(news: News)
    fun clearAllNews()
    fun getNews(): List<News>
}