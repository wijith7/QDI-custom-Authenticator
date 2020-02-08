package sample.custom.authenticator.qdi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class QDIMockClient implements QDIClient {

    private static final Log log = LogFactory.getLog(QDIMockClient.class);
    private static final long serialVersionUID = -7290328308157020382L;

    @Override
    public boolean qdiAuthenticate(String username, String password) {

        return true;

    }

    private boolean callWebService(String soapAction) {

        HelloWorldImplService helloService = new HelloWorldImplService();
        HelloWorld hello = helloService.getHelloWorldImplPort();

        return "1".equals(hello.getHelloWorldAsString(soapAction));
    }
}
//    public static void callWebService(String soapAction) throws IOException {
//        // Create a StringEntity for the SOAP XML.
//        String body = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
//                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.dataaccess.com/webservicesserver/\">" +
//                "<soapenv:Header/>" +
//                "<soapenv:Body>" +
//                "<web:NumberToDollars> <web:dNum>3</web:dNum> </web:NumberToDollars>" +
//                "</soapenv:Body>" +
//                "</soapenv:Envelope>";
//
//        StringEntity stringEntity = new StringEntity(body, "UTF-8");
//        stringEntity.setChunked(true);
//
//        // Request parameters and other properties.
//        HttpPost httpPost = new HttpPost("http://www.dataaccess.com/webservicesserver/numberconversion.wso");
//        httpPost.setEntity(stringEntity);
//        httpPost.addHeader("Accept", "text/xml");
//        httpPost.addHeader("Content-Type", "text/xml");
//        httpPost.addHeader("SOAPAction", soapAction);
//
//        // Execute and get the response.
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpResponse response = httpClient.execute(httpPost);
//        HttpEntity entity = response.getEntity();
//
//        String strResponse = null;
//        if (entity != null) {
//            strResponse = EntityUtils.toString(entity);
//            System.out.println(strResponse);
//        }
//    }


