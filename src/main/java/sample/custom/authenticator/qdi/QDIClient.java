package sample.custom.authenticator.qdi;

import java.io.Serializable;

public interface QDIClient extends Serializable {

    boolean qdiAuthenticate(String username, String password);
}
