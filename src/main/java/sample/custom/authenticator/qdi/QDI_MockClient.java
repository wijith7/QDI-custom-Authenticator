package sample.custom.authenticator.qdi;

import net.minidev.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QDI_MockClient implements QDIClient {

    @Override
    public boolean qdiAuthenticator(String username, String password) {

                try {
                    String url = "http://schemas.xmlsoap.org/soap/envelope/";
                    URL obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
                    String countryCode="Canada";
                    String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                            "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"> " +
                            " <soap12:Body> " +
                            " <GetHolidaysAvailable xmlns=\"http://www.holidaywebservice.com/HolidayService_v2/\"> " +
                            " <countryCode>"+countryCode+"</countryCode>" +
                            " </GetHolidaysAvailable>" +
                            " </soap12:Body>" +
                            "</soap12:Envelope>";
                    con.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(xml);
                    wr.flush();
                    wr.close();
                    String responseStatus = con.getResponseMessage();
                    System.out.println(responseStatus);
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    System.out.println("response:" + response.toString());
                } catch (Exception e) {
                    System.out.println(e);
                }

        return false;
    }
}
