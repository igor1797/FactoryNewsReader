package hr.ferit.igorkuridza.factorynewsreader.ui.activities.main

import hr.ferit.igorkuridza.factorynewsreader.model.News
import hr.ferit.igorkuridza.factorynewsreader.ui.base.BasePresenter

interface MainActivityContract {

    interface View{

        fun onNoInternetConnection()

        fun onSomethingWentWrong(code: Int)

        fun onGetNewsSuccessful(news: List<News>)

    }

    interface Presenter: BasePresenter<View>{

        fun getNews()
    }
}