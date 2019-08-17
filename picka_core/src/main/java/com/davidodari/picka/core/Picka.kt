package com.davidodari.picka.core

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.davidodari.picka.core.exceptions.MimeTypeException
import com.davidodari.picka.core.media.MediaType

/**
 * Created By David Odari
 * On 14/08/19
 *
 **/
class Picka {

    companion object {

        private const val ACTION_PICK_MEDIA = 1

        /**
         * @param activity caller activity from which image is selected
         * @param mediaType typeFormat of media to be presented
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
                val typeName = typeFormat.substring(0, typeFormat.indexOf('/'))

                type = typeFormat
                action = Intent.ACTION_GET_CONTENT

                mimetypes?.let { types ->

                    types.forEach { type ->
                        if (!type.contains(typeName))
                            throw MimeTypeException("Invalid Mime Type Format, use $typeName mime types")
                    }

                    putExtra(Intent.EXTRA_MIME_TYPES, types)
                }
            }
            val media: String = chooserMediaTypeTitle(mediaType, activity)

            activity.startActivityForResult(
                Intent.createChooser(intent, activity.getString(R.string.label_select_media, media)), ACTION_PICK_MEDIA
            )
        }

        private fun chooserMediaTypeTitle(mediaType: MediaType, activity: Activity): String {
            return when (mediaType) {
                MediaType.IMAGE -> activity.getString(R.string.label_media_type_image)
                MediaType.VIDEO -> activity.getString(R.string.label_media_type_video)
            }
        }

        /**
         * Returns URI to selected media file
         */
        fun collectMediaFile(requestCode: Int, resultCode: Int, data: Intent?): Uri? {
            val isPickingMedia = requestCode == ACTION_PICK_MEDIA && Activity.RESULT_OK == resultCode
            return if (isPickingMedia) data?.data else null
        }
    }
}