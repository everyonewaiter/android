package com.handwoong.everyonewaiter

import android.app.AlertDialog
import android.content.Context
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView

class WebChromeClientCustom(private val context: Context) : WebChromeClient() {
    override fun onJsAlert(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        AlertDialog.Builder(context)
            .setTitle(R.string.app_name)
            .setMessage(message)
            .setPositiveButton("확인") { _, _ -> result?.confirm() }
            .setNegativeButton("취소") { _, _ -> result?.cancel() }
            .setOnCancelListener {
                result?.cancel()
                it.dismiss()
            }
            .setCancelable(false)
            .create()
            .show()
        return true
    }

    override fun onJsConfirm(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        AlertDialog.Builder(context)
            .setTitle(R.string.app_name)
            .setMessage(message)
            .setPositiveButton("확인") { _, _ -> result?.confirm() }
            .setNegativeButton("취소") { _, _ -> result?.cancel() }
            .setOnCancelListener {
                result?.cancel()
                it.dismiss()
            }
            .setCancelable(false)
            .create()
            .show()
        return true
    }
}
