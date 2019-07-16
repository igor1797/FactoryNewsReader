package hr.ferit.igorkuridza.factorynewsreader.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.igorkuridza.factorynewsreader.common.loadImage
import hr.ferit.igorkuridza.factorynewsreader.model.News
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_news.view.*


class NewsHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindItem(news: News, onNewsClickListener: (News) -> Unit){
        containerView.ivNewsImage.loadImage(news.newsImagePath)
        containerView.tvNewsTitle.text = news.newsTitle
        containerView.tvNewsDescription.text = news.newsDescription
        containerView.setOnClickListener {
            onNewsClickListener(news)
        }
    }
}