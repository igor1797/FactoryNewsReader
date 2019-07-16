package hr.ferit.igorkuridza.factorynewsreader.common

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ImageView.loadImage(imageUrl: String){
    Glide.with(this).load(imageUrl).into(this)
}

fun Context.displayToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
