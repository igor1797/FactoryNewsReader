package hr.ferit.igorkuridza.factorynewsreader.ui.fragments

import android.os.Bundle
import hr.ferit.igorkuridza.factorynewsreader.R
import hr.ferit.igorkuridza.factorynewsreader.common.EXTRA_NEWS_DESCRIPTION
import hr.ferit.igorkuridza.factorynewsreader.common.EXTRA_NEWS_IMAGE_PATH
import hr.ferit.igorkuridza.factorynewsreader.common.EXTRA_NEWS_TITLE
import hr.ferit.igorkuridza.factorynewsreader.common.loadImage
import hr.ferit.igorkuridza.factorynewsreader.ui.base.BaseFragment
import kotlinx.android.synthetic.main.item_news.ivNewsImage
import kotlinx.android.synthetic.main.item_news.tvNewsDescription
import kotlinx.android.synthetic.main.item_news.tvNewsTitle

class SingleNewsDetailsFragment(): BaseFragment() {

    override fun getLayoutResourceId() = R.layout.fragment_details_news_single

    override fun setUpUi() {
        ivNewsImage.loadImage(arguments?.getString(EXTRA_NEWS_IMAGE_PATH)!!)
        tvNewsTitle.text = arguments?.getString(EXTRA_NEWS_TITLE)
        tvNewsDescription.text = arguments?.getString(EXTRA_NEWS_DESCRIPTION)
    }

    companion object{
        fun newInstance(title: String, description: String, imagePath: String): SingleNewsDetailsFragment {
            val bundle = Bundle().apply {
                putString(EXTRA_NEWS_TITLE, title)
                putString(EXTRA_NEWS_DESCRIPTION, description)
                putString(EXTRA_NEWS_IMAGE_PATH, imagePath)
            }
            return SingleNewsDetailsFragment().apply { arguments = bundle }
        }
    }
}