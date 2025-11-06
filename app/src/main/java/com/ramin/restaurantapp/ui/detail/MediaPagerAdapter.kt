package com.ramin.restaurantapp.ui.detail

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ramin.restaurantapp.databinding.ItemMediaPageBinding
import com.ramin.restaurantapp.model.FoodMedia

class MediaPagerAdapter(
    private val mediaItems: List<FoodMedia>
) : RecyclerView.Adapter<MediaPagerAdapter.MediaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val binding = ItemMediaPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MediaViewHolder(binding)
    }

    override fun getItemCount(): Int = mediaItems.size

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.bind(mediaItems[position])
    }

    override fun onViewRecycled(holder: MediaViewHolder) {
        super.onViewRecycled(holder)
        holder.cleanup()
    }

    inner class MediaViewHolder(private val binding: ItemMediaPageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(media: FoodMedia) {
            when (media) {
                is FoodMedia.Image -> showImage(media.url)
                is FoodMedia.Video -> showVideo(media.url)
            }
        }

        private fun showImage(url: String) {
            binding.mediaVideo.visibility = View.GONE
            binding.mediaImage.visibility = View.VISIBLE
            binding.mediaPlayIcon.visibility = View.GONE
            Glide.with(binding.mediaImage.context)
                .load(url)
                .centerCrop()
                .into(binding.mediaImage)
        }

        private fun showVideo(url: String) {
            binding.mediaImage.visibility = View.GONE
            binding.mediaVideo.visibility = View.VISIBLE
            binding.mediaPlayIcon.visibility = View.VISIBLE
            val controller = MediaController(binding.mediaVideo.context)
            controller.setAnchorView(binding.mediaVideo)
            binding.mediaVideo.apply {
                setMediaController(controller)
                setVideoURI(Uri.parse(url))
                setOnPreparedListener { mp ->
                    mp.isLooping = true
                    binding.mediaPlayIcon.visibility = View.GONE
                    start()
                }
                setOnCompletionListener {
                    binding.mediaPlayIcon.visibility = View.VISIBLE
                }
                setOnClickListener {
                    if (isPlaying) {
                        pause()
                        binding.mediaPlayIcon.visibility = View.VISIBLE
                    } else {
                        start()
                        binding.mediaPlayIcon.visibility = View.GONE
                    }
                }
            }
        }

        fun cleanup() {
            binding.mediaVideo.stopPlayback()
            binding.mediaPlayIcon.visibility = View.VISIBLE
        }
    }
}
