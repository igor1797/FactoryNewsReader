package hr.ferit.igorkuridza.factorynewsreader.presentation


import hr.ferit.igorkuridza.factorynewsreader.common.RESPONSE_OK
import hr.ferit.igorkuridza.factorynewsreader.common.dataOlderThanFiveMinutes
import hr.ferit.igorkuridza.factorynewsreader.model.News
import hr.ferit.igorkuridza.factorynewsreader.model.NewsResponse
import hr.ferit.igorkuridza.factorynewsreader.networking.interactors.NewsInteractor
import hr.ferit.igorkuridza.factorynewsreader.persistence.NewsPrefs
import hr.ferit.igorkuridza.factorynewsreader.persistence.NewsRepository
import hr.ferit.igorkuridza.factorynewsreader.persistence.PREFS_KEY
import hr.ferit.igorkuridza.factorynewsreader.ui.activities.main.MainActivityContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MainActivityPresentation(private val newsInteractor: NewsInteractor, private val repository: NewsRepository): MainActivityContract.Presenter {

    private lateinit var view: MainActivityContract.View

    override fun setView(view: MainActivityContract.View) {
        this.view = view
    }

    override fun getNews() {
        val timeDataStored = NewsPrefs.getTime(PREFS_KEY, -1L)!!
        if(repository.getNews().isEmpty() || (timeDataStored != -1L && dataOlderThanFiveMinutes(timeDataStored)))
            newsInteractor.getTopBBCNews(topBBCNewsCallback())
        else
            view.onGetNewsSuccessful(repository.getNews())
    }

    private fun topBBCNewsCallback(): Callback<NewsResponse> = object : Callback<NewsResponse> {
        override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            view.onNoInternetConnection()
        }

        override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
            if (response.isSuccessful) {
                when (response.code()) {
                    RESPONSE_OK -> response.body()?.let { handleOkResponse(it.news) }
                }
            } else
                view.onSomethingWentWrong(response.code())
        }
    }

    private fun handleOkResponse(news: ArrayList<News>){
        view.onGetNewsSuccessful(news)
        repository.clearAllNews()
        news.forEach {
            repository.addSingleNews(it)
        }
        NewsPrefs.storeTime(PREFS_KEY, Calendar.getInstance().timeInMillis)
    }
}