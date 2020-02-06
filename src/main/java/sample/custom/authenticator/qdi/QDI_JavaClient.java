package sample.custom.authenticator.qdi;

public class QDI_JavaClient implements QDIClient {

    @Override
    public boolean qdiAuthenticator(String username, String password) {

        if ("foo".equals(username) && "pass".equals(password)) {
            return true;
        }
        return false;
    }
}
