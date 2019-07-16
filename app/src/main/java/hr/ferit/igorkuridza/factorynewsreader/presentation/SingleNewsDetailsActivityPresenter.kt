package hr.ferit.igorkuridza.factorynewsreader.presentation

import hr.ferit.igorkuridza.factorynewsreader.model.News
import hr.ferit.igorkuridza.factorynewsreader.persistence.NewsRoomRepository
import hr.ferit.igorkuridza.factorynewsreader.ui.activities.single.SingleNewsDetailsActivityContract

class SingleNewsDetailsActivityPresenter(private val repository: NewsRoomRepository): SingleNewsDetailsActivityContract.Presenter {

    private lateinit var view: SingleNewsDetailsActivityContract.View

    override fun setView(view: SingleNewsDetailsActivityContract.View) {
        this.view = view
    }

    override fun getCurrentItemPosition(news: News) {
        val position = repository.getNews().indexOf(news)
        view.onGetCurrentItemPositionSuccessful(position)
    }

    override fun getCurrentItemTitle(position: Int) {
        val title = repository.getNews()[position].newsTitle
        view.onGetCurrentItemTitleSuccessful(title)
    }

    override fun getNews() {
        view.onGetNewsSuccessful(repository.getNews())
    }
}