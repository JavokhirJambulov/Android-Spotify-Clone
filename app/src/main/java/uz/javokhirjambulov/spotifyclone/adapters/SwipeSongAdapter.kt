package uz.javokhirjambulov.spotifyclone.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.google.android.material.textview.MaterialTextView
import uz.javokhirjambulov.spotifyclone.R

class SwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            val text = "${song.title} - ${song.subtitle}"
            val tvPrimary =  findViewById<MaterialTextView>(R.id.tvPrimary)
            tvPrimary.text = text

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

}



















