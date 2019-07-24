package hr.ferit.igorkuridza.factorynewsreader.networking

import hr.ferit.igorkuridza.factorynewsreader.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("articles")
    fun getNews(
        @Query("source") source: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}