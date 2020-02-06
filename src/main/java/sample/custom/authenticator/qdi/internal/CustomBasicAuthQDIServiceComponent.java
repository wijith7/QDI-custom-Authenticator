/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package sample.custom.authenticator.qdi.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;
import sample.custom.authenticator.qdi.CustomQDIAuthenticator;
import org.wso2.carbon.user.core.service.RealmService;

/**
 * @scr.component name="sample.custom.authenticator.qdi.component" immediate="true"
 * @scr.reference name="realm.service"
 * interface="org.wso2.carbon.user.core.service.RealmService"cardinality="1..1"
 * policy="dynamic" bind="setRealmService" unbind="unsetRealmService"
 */
public class CustomBasicAuthQDIServiceComponent {

    private static Log log = LogFactory.getLog(CustomBasicAuthQDIServiceComponent.class);

    private static RealmService realmService;

    public static RealmService getRealmService() {
        return realmService;
    }

    protected void setRealmService(RealmService realmService) {
        log.info("======================Setting the Realm Service================");
        CustomBasicAuthQDIServiceComponent.realmService = realmService;
    }

    protected void activate(ComponentContext ctxt) {
        try {
            CustomQDIAuthenticator auth = new CustomQDIAuthenticator();
            ctxt.getBundleContext().registerService(ApplicationAuthenticator.class.getName(), auth, null);
            log.info("===================CustomQDI_Authenticator bundle is activated======");
            if (log.isDebugEnabled()) {
                log.debug("CustomQDI_Authenticator bundle is activated");
            }
        } catch (Throwable e) {
            log.error("CustomQDI_Authenticator bundle activation Failed", e);
        }
    }

    protected void deactivate(ComponentContext context) {
        log.info("==============CustomQDI_Authenticator bundle is deactivated============");
        if (log.isDebugEnabled()) {
            log.debug("CustomQDI_Authenticator bundle is deactivated");
        }
    }

    protected void unsetRealmService(RealmService realmService) {
        if(log.isDebugEnabled()) {
            log.debug("UnSetting the Realm Service");
        }
        CustomBasicAuthQDIServiceComponent.realmService = null;
    }

}
