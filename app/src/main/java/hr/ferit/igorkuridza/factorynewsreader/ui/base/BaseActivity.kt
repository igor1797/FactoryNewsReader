package hr.ferit.igorkuridza.factorynewsreader.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())

        setUpUI()
    }

    abstract fun getLayoutResourceId(): Int

    abstract fun setUpUI()
}