package hr.ferit.igorkuridza.factorynewsreader.networking.interactors

import hr.ferit.igorkuridza.factorynewsreader.model.NewsResponse
import retrofit2.Callback

interface NewsInteractor {

    fun getTopBBCNews(topBBCNewsCallback: Callback<NewsResponse>)
}