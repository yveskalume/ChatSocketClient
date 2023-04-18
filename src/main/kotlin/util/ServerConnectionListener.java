package util;

public interface ServerConnectionListener {
    void onSuccess();
    void onError(Throwable throwable);
}
