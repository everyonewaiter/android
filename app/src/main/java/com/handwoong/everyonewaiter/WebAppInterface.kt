package com.handwoong.everyonewaiter

import android.media.MediaPlayer
import android.webkit.JavascriptInterface

class WebAppInterface(private var player: MediaPlayer?) {

    @JavascriptInterface
    fun play() {
        closePlayer()
        player = MediaPlayer()
        player?.setDataSource("https://waiter.handwoong.com/js/alram.mp3")
        player?.prepare()
        player?.start()
    }

    @JavascriptInterface
    fun stop() {
        if (player != null && player!!.isPlaying) {
            player?.stop()
        }
    }

    private fun closePlayer() {
        if (player != null) {
            player?.release()
            player = null
        }
    }
}
