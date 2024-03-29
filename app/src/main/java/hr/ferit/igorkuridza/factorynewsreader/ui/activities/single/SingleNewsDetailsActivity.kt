package hr.ferit.igorkuridza.factorynewsreader.ui.activities.single

import androidx.viewpager.widget.ViewPager
import hr.ferit.igorkuridza.factorynewsreader.R
import hr.ferit.igorkuridza.factorynewsreader.common.EXTRA_SINGLE_NEWS
import hr.ferit.igorkuridza.factorynewsreader.model.News
import hr.ferit.igorkuridza.factorynewsreader.persistence.NewsRoomRepository
import hr.ferit.igorkuridza.factorynewsreader.presentation.SingleNewsDetailsActivityPresenter
import hr.ferit.igorkuridza.factorynewsreader.ui.base.BaseActivity
import hr.ferit.igorkuridza.factorynewsreader.ui.adapters.NewsPagerAdapter
import kotlinx.android.synthetic.main.activity_details_news_single.*

class SingleNewsDetailsActivity(): BaseActivity(), ViewPager.OnPageChangeListener, SingleNewsDetailsActivityContract.View {

    private val presenter = SingleNewsDetailsActivityPresenter(NewsRoomRepository())
    private val pagerAdapter by lazy {
        NewsPagerAdapter(supportFragmentManager)
    }

    override fun getLayoutResourceId() = R.layout.activity_details_news_single

    override fun setUpUI() {
        presenter.setView(this)
        setUpViewPager()

        val news = intent?.getParcelableExtra<News>(EXTRA_SINGLE_NEWS)

        presenter.getCurrentItemPosition(news!!)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = news.newsTitle
    }

    private fun setUpViewPager(){
        newsPager.adapter = pagerAdapter
        presenter.getNews()
        newsPager.addOnPageChangeListener(this)
    }

    override fun onPageSelected(position: Int) {
        presenter.getCurrentItemTitle(position)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onGetNewsSuccessful(news: List<News>) {
        pagerAdapter.setNews(news)
    }

    override fun onGetCurrentItemTitleSuccessful(title: String) {
        supportActionBar?.title = title
    }

    override fun onGetCurrentItemPositionSuccessful(position: Int){
        newsPager.currentItem = position
    }

    override fun onPageScrollStateChanged(state: Int){}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int){}
}
