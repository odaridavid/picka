package com.davidodari.picka

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davidodari.picka.core.Picka
import com.davidodari.picka.core.media.MediaType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pick_image_button.setOnClickListener {
            Picka.pickMedia(this, MediaType.IMAGE, arrayOf("image/jpeg", "image/png"))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val uri = Picka.collectMediaFile(requestCode, resultCode, data)
        uri?.let {
            put_image_view.setImageURI(it)
        }
    }

}
