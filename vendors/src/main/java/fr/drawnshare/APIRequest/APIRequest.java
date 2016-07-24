package fr.drawnshare.APIRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by brick on 06/07/16.
 */
public class APIRequest {
  private final String API_URL = "http://127.0.0.1";
  private final int API_PORT = 3000;
  private String response;
  private HttpURLConnection APIConnection;

  public APIRequest(String method, String path) {
    URL url;

    try {
      url = new URL(API_URL + ":" + API_PORT + path);
      this.APIConnection = (HttpURLConnection) url.openConnection();
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      this.APIConnection.setRequestMethod(method);
    } catch (ProtocolException e1) {
      e1.printStackTrace();
    }
    this.APIConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    this.APIConnection.setDoOutput(true);
  }

  public void execute(){
    InputStream is;
    try {
      is = this.APIConnection.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));

      StringBuilder response = new StringBuilder();

      String line;
        while((line = br.readLine()) != null){
          response.append(line);
          response.append('\r');
      }
        br.close();
        this.response = response.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getResponse() {
    return this.response;
  }
}
