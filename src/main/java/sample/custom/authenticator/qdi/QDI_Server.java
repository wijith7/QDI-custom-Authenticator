package sample.custom.authenticator.qdi;

public class QDI_Server implements QDIClient {

    @Override
    public boolean qdiAuthenticator(String username, String password) {

        return false;
    }
}
