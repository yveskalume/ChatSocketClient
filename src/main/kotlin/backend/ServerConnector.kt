package backend

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket


class ServerConnector : Runnable {
    var socket: Socket? = null
    var bufferedReader: BufferedReader? = null
    var printWriter: PrintWriter? = null

    fun connectToServer(serverIp: String?, email: String?, onSuccess: () -> Unit, onError: (Throwable) -> Unit) {
        try {
            socket = Socket(serverIp, 1235)

            //read
            bufferedReader = BufferedReader(InputStreamReader(socket!!.getInputStream()))

            //writing
            printWriter = PrintWriter(socket!!.getOutputStream(), true)
            printWriter!!.println(email) // Send to server side

            onSuccess()

            Thread(this).start();
        } catch (e: Exception) {
            onError(e)
            println("Erreur de connexion socket $e")
        }
    }

    override fun run() {
        var data: String? = null
        try {
            while (bufferedReader!!.readLine().also { data = it } != null) {
//                textArea.append(data + "\n");
                println(data)
            }
        } catch (e: Exception) {
            println("$e--> Client run fail")
        }
    }
}
