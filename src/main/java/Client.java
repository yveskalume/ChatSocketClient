import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private static String clientUserName;

    public static void sendMessage(String message) {
        try {
            bufferedWriter.write(clientUserName + ": " + message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println(e + " Erreur de connection au serveur");
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    public static void connectToServer(String ip, String name,ServerConnectionListener listener) {
        try {
            socket = new Socket(ip, 1234);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            clientUserName = name;

            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            listener.onSuccess();
        } catch (Exception e) {
            System.out.println(e + " Erreur de connection au serveur");
            listener.onError(e);
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    public static void listenNewMessages(OnNewMessageListener onNewMessageListener) {
        new Thread(() -> {
            String message;
            while (socket.isConnected()) {
                try {
                    message = bufferedReader.readLine();
                    onNewMessageListener.onNewMessage(message);
                } catch (IOException e) {
                    System.out.println(e + "Une erreur s'est produite");
                    closeAll(socket, bufferedReader, bufferedWriter);
                }
            }
        }).start();
    }

    private static void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
