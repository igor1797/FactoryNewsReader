package hr.ferit.igorkuridza.factorynewsreader.ui.fragments

import android.os.Bundle
import hr.ferit.igorkuridza.factorynewsreader.R
import hr.ferit.igorkuridza.factorynewsreader.common.*
import hr.ferit.igorkuridza.factorynewsreader.model.News
import hr.ferit.igorkuridza.factorynewsreader.ui.base.BaseFragment
import kotlinx.android.synthetic.main.item_news.ivNewsImage
import kotlinx.android.synthetic.main.item_news.tvNewsDescription
import kotlinx.android.synthetic.main.item_news.tvNewsTitle

class SingleNewsDetailsFragment(): BaseFragment() {

    override fun getLayoutResourceId() = R.layout.fragment_details_news_single

    override fun setUpUi() {
        val news = arguments?.getParcelable<News>(EXTRA_SINGLE_NEWS)
            ivNewsImage.loadImage(news!!.newsImagePath)
            tvNewsTitle.text = news.newsTitle
            tvNewsDescription.text = news.newsDescription
    }

    companion object{
        fun newInstance(singleNews: News): SingleNewsDetailsFragment {
            val bundle = Bundle().apply {
                putParcelable(EXTRA_SINGLE_NEWS, singleNews)
            }
            return SingleNewsDetailsFragment().apply { arguments = bundle }
        }
    }
}