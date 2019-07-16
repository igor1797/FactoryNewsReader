package hr.ferit.igorkuridza.factorynewsreader.ui.activities.single

import hr.ferit.igorkuridza.factorynewsreader.model.News
import hr.ferit.igorkuridza.factorynewsreader.ui.base.BasePresenter

interface SingleNewsDetailsActivityContract {

    interface View{

        fun onGetCurrentItemPositionSuccessful(position: Int)

        fun onGetCurrentItemTitleSuccessful(title: String)

        fun onGetNewsSuccessful(news: List<News>)
    }

    interface Presenter: BasePresenter<View>{

        fun getCurrentItemPosition(news: News)

        fun getCurrentItemTitle(position: Int)

        fun getNews()
    }
}