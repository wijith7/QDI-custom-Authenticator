package sample.custom.authenticator.qdi.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;
import sample.custom.authenticator.qdi.CustomQDIAuthenticator;

/// TODO: 2/7/20 change to annotation check 5.10

/**
 * @scr.component name="sample.custom.authenticator.qdi.component" immediate="true"
 */
public class CustomBasicAuthQDIServiceComponent {

    private static Log log = LogFactory.getLog(CustomBasicAuthQDIServiceComponent.class);

    protected void activate(ComponentContext ctxt) {

        try {
            CustomQDIAuthenticator customQDIAuthenticator = new CustomQDIAuthenticator();
            ctxt.getBundleContext()
                    .registerService(ApplicationAuthenticator.class.getName(), customQDIAuthenticator, null);
            log.info("CustomQDIAuthenticator bundle is activated");

        } catch (Exception e) {
            log.error("CustomQDIAuthenticator bundle activation Failed", e);
        }
    }

    protected void deactivate(ComponentContext context) {

        log.info("CustomQDIAuthenticator bundle is deactivated");
    }

}
