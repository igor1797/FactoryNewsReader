package hr.ferit.igorkuridza.factorynewsreader.ui.activities.main

import android.app.AlertDialog
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.igorkuridza.factorynewsreader.R
import hr.ferit.igorkuridza.factorynewsreader.common.*
import hr.ferit.igorkuridza.factorynewsreader.model.News
import hr.ferit.igorkuridza.factorynewsreader.networking.BackendFactory
import hr.ferit.igorkuridza.factorynewsreader.persistence.NewsRoomRepository
import hr.ferit.igorkuridza.factorynewsreader.presentation.MainActivityPresentation
import hr.ferit.igorkuridza.factorynewsreader.ui.activities.single.SingleNewsDetailsActivity
import hr.ferit.igorkuridza.factorynewsreader.ui.base.BaseActivity
import hr.ferit.igorkuridza.factorynewsreader.ui.adapters.NewsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainActivityContract.View {

    private val presenter = MainActivityPresentation(BackendFactory.getNewsInteractor(), NewsRoomRepository())
    private val newsAdapter by lazy {
        NewsAdapter { onNewsClicked(it) }
    }

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun setUpUI() {
        presenter.setView(this)
        recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }
        getNews()
        swipeRefresh.setOnRefreshListener { refresh() }
    }

    private fun refresh(){
        swipeRefresh.isRefreshing = true
        getNews()
        swipeRefresh.isRefreshing = false
    }

    private fun getNews() = presenter.getNews()

    override fun onNoInternetConnection() = showPopUpDialog()

    override fun onGetNewsSuccessful(news: List<News>) {
        newsAdapter.setNews(news)
        progressBar.visibility = View.GONE
    }

    override fun onSomethingWentWrong(code: Int) = displayToast(convertCodeToMessage(code))

    private fun showPopUpDialog(){
        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialogTitle))
            .setMessage(getString(R.string.dialogMessage))
            .setNegativeButton(getString(R.string.alertNegativeButtonText)) { _, _ -> }
        dialog.show()
    }

    private fun onNewsClicked(news: News){
        val intent: Intent = Intent(this ,
            SingleNewsDetailsActivity::class.java).apply {
            putExtra(EXTRA_NEWS_TITLE, news.newsTitle)
            putExtra(EXTRA_NEWS_DESCRIPTION, news.newsDescription)
            putExtra(EXTRA_NEWS_IMAGE_PATH, news.newsImagePath)
        }
        startActivity(intent)
    }
}
