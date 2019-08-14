package com.davidodari.picka

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davidodari.picka.core.media.MediaType
import com.davidodari.picka.core.Picka
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pick_image_button.setOnClickListener {
            Picka.pickMedia(this, MediaType.VIDEO, arrayOf("image/jpeg", "image/png"))
        }
    }

}
