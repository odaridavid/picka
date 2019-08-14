package com.davidodari.picka.core

import android.app.Activity
import android.content.Intent
import com.davidodari.picka.core.exceptions.MimeTypeException

/**
 * Created By David Odari
 * On 14/08/19
 *
 **/
class Picka {

    //TODO Support multiple media types
    companion object {

        private const val ACTION_PICK_MEDIA = 1

        /**
         * @param activity caller activity from which image is selected
         * @param mediaTypes typeFormat(s) of media to be presented
         * @param mimetypes the supported mimetypes for specified mediatype
         */
        @JvmOverloads
        fun pickMedia(
            activity: Activity,
            mediaType: MediaType = MediaType.IMAGE,
            mimetypes: Array<String>? = null
        ) {

            val intent = Intent().apply {

                val typeFormat = mediaType.typeFormat

                type = typeFormat
                action = Intent.ACTION_GET_CONTENT

                if (mimetypes != null) {
                    mimetypes.forEach { type ->
                        if (!type.contains(typeFormat.substring(0, typeFormat.length - 2))) {
                            val typeName = type.substring(0, type.indexOf('/'))
                            throw MimeTypeException("Invalid Mime Type Format, use $typeName mime types")
                        }
                    }
                    putExtra(Intent.EXTRA_MIME_TYPES, mimetypes)
                }
            }
            val media: String = when (mediaType) {
                MediaType.IMAGE -> activity.getString(R.string.label_media_type_image)
                MediaType.VIDEO -> activity.getString(R.string.label_media_type_video)
            }
            activity.startActivityForResult(
                Intent.createChooser(
                    intent,
                    activity.getString(R.string.label_select_media, media)
                ), ACTION_PICK_MEDIA
            )
        }
    }
}