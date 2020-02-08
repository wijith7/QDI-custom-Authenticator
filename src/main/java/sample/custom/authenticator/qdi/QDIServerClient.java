package sample.custom.authenticator.qdi;

public class QDIServerClient implements QDIClient {

    @Override
    public boolean qdiAuthenticate(String username, String password) {

        return false;
    }
}
