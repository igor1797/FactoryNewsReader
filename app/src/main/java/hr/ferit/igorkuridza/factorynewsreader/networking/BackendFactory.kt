package hr.ferit.igorkuridza.factorynewsreader.networking

import hr.ferit.igorkuridza.factorynewsreader.common.BASE_URL
import hr.ferit.igorkuridza.factorynewsreader.networking.interactors.NewsInteractor
import hr.ferit.igorkuridza.factorynewsreader.networking.interactors.NewsInteractorImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BackendFactory {

    private var retrofit: Retrofit? = null

    private val httpClient= OkHttpClient.Builder().build()

    private val client: Retrofit? = if(retrofit == null) createRetrofit() else retrofit

    private fun createRetrofit(): Retrofit? {
        retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    private fun getService(): NewsApiService = this.client!!.create(NewsApiService::class.java)

    fun getNewsInteractor(): NewsInteractor = NewsInteractorImpl(getService())
}