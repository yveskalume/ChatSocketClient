package logic

import androidx.compose.runtime.mutableStateListOf

object MessageDataSource {

    val messages = mutableStateListOf<String>()

    fun getMessages() {
        Client.listenNewMessages{
            messages.add(it)
        }
    }

    fun sendMessage(message: String) {
        Client.sendMessage(message)
    }
}