package hr.ferit.igorkuridza.factorynewsreader.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.igorkuridza.factorynewsreader.R
import hr.ferit.igorkuridza.factorynewsreader.model.News

class NewsAdapter(private val onNewsClickListener: (News) -> Unit): RecyclerView.Adapter<NewsHolder>() {

    private var listNews = mutableListOf<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(view)
    }

    override fun getItemCount() = listNews.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bindItem(listNews[position], onNewsClickListener)
    }

    fun setNews(news: List<News>){
        this.listNews.clear()
        this.listNews.addAll(news)
        notifyDataSetChanged()
    }
}