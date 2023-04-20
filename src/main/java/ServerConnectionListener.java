public interface ServerConnectionListener {
    void onSuccess();
    void onError(Throwable t);
}
