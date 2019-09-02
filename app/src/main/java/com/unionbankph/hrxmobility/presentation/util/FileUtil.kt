package com.unionbankph.hrxmobility.presentation.util

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns


class FileUtil {

    companion object {
        fun getFileName(uri: Uri, mContentResolver: ContentResolver): String {
            var result: String = ""
            if (uri.scheme!!.equals("content")) {
                val cursor = mContentResolver.query(uri, null, null, null, null)
                try {
                    if (cursor != null && cursor.moveToFirst()) {
                        result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                    }
                } finally {
                    cursor!!.close()
                }
            }

            return result
        }
    }

}