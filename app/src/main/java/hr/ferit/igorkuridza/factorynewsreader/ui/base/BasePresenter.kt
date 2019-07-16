package hr.ferit.igorkuridza.factorynewsreader.ui.base

interface BasePresenter<T> {
    fun setView(view: T)
}