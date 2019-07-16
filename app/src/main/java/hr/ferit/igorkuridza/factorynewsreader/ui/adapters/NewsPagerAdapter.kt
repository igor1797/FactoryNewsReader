package hr.ferit.igorkuridza.factorynewsreader.ui.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import hr.ferit.igorkuridza.factorynewsreader.model.News
import hr.ferit.igorkuridza.factorynewsreader.ui.fragments.SingleNewsDetailsFragment

class NewsPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    private val newsList = mutableListOf<News>()

    override fun getItem(position: Int)
            = SingleNewsDetailsFragment.newInstance(newsList[position].newsTitle, newsList[position].newsDescription, newsList[position].newsImagePath)

    override fun getCount() = newsList.size

    fun setNews(newsList: List<News>){
        this.newsList.clear()
        this.newsList.addAll(newsList)
        notifyDataSetChanged()
    }


}