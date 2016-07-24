package fr.drawnshare.APIRequest;

/**
 * Created by brick on 06/07/16.
 */
public class APIRequestTest {
  public static void main(String[] argv){
    APIRequest request = new APIRequest("GET", "/projects");
    request.execute();
    String response = request.getResponse();
    System.out.println(response);
  }
}
