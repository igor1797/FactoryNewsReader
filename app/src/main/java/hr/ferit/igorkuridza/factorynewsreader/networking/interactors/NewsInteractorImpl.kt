package hr.ferit.igorkuridza.factorynewsreader.networking.interactors

import hr.ferit.igorkuridza.factorynewsreader.common.API_KEY
import hr.ferit.igorkuridza.factorynewsreader.common.SORT_BY
import hr.ferit.igorkuridza.factorynewsreader.common.SOURCE
import hr.ferit.igorkuridza.factorynewsreader.model.NewsResponse
import hr.ferit.igorkuridza.factorynewsreader.networking.NewsApiService
import retrofit2.Callback

class NewsInteractorImpl(private val newsApiService: NewsApiService): NewsInteractor {

    override fun getTopBBCNews(topBBCNewsCallback: Callback<NewsResponse>) {
        newsApiService.getNews(SOURCE, SORT_BY, API_KEY).enqueue(topBBCNewsCallback)
    }
}