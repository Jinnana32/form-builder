package com.unionbankph.hrxmobility.presentation.util.helper

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns
import android.provider.MediaStore
import android.content.ContentValues
import android.content.Context
import java.io.File


class FileHelper {

    companion object {
        fun getFileName(uri: Uri, mContentResolver: ContentResolver): String {
            var result: String? = null
            if (uri.getScheme().equals("content")) {
                val cursor = mContentResolver.query(uri, null, null, null, null)
                try {
                    if (cursor != null && cursor!!.moveToFirst()) {
                        result = cursor!!.getString(cursor!!.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                    }
                } finally {
                    cursor!!.close()
                }
            }
            if (result == null) {
                result = uri.getPath()
                val cut = result!!.lastIndexOf('/')
                if (cut != -1) {
                    result = result.substring(cut + 1)
                }
            }
            return result
        }

        fun getImageContentUri(context: Context, mFile: File): Uri? {
            val filePath = mFile.getAbsolutePath()
            val cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Images.Media._ID),
                MediaStore.Images.Media.DATA + "=? ",
                arrayOf<String>(filePath), null
            )
            if (cursor != null && cursor!!.moveToFirst()) {
                val id = cursor!!.getInt(cursor!!.getColumnIndex(MediaStore.MediaColumns._ID))
                cursor!!.close()
                return Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "" + id)
            } else {
                if (mFile.exists()) {
                    val values = ContentValues()
                    values.put(MediaStore.Images.Media.DATA, filePath)
                    return context.getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values
                    )
                } else {
                    return null
                }
            }
        }
    }

}