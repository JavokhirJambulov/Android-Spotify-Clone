package uz.javokhirjambulov.spotifyclone.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import uz.javokhirjambulov.spotifyclone.R
import javax.inject.Inject

class SongAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseSongAdapter(R.layout.list_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
             val tvPrimary = findViewById<TextView>(R.id.tvPrimary)
            val tvSecondary = findViewById<TextView>(R.id.tvSecondary)
            val ivItemImage = findViewById<ImageView>(R.id.ivItemImage)
            tvPrimary.text = song.title
            tvSecondary.text = song.subtitle
            glide.load(song.imageUrl).into(ivItemImage)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

}



















