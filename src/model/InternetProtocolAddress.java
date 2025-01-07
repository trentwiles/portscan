package model;

import java.net.http.*;
import java.net.URI;
import java.io.IOException;


public class InternetProtocolAddress implements InternetProtocol {
  private final int digitOne;
  private final int digitTwo;
  private final int digitThree;
  private final int digitFour;

  private final String API_BASE_URL = "https://ipinfo.io/";

  public InternetProtocolAddress(String ip) {
    // throws exception if there's an issue
    int[] digits = fromString(ip);

    this.digitOne = digits[0];
    this.digitTwo = digits[1];
    this.digitThree = digits[2];
    this.digitFour = digits[3];
  }

  public static boolean validate(String ip) {
    if (ip == null || ip.isEmpty()) {
      return false;
    }

    String[] chrs = ip.split("\\.");
    if (chrs.length != 4) {
      return false;
    }

    for (String num : chrs) {
      int x = -1;
      try {
        x = Integer.parseInt(num);
      } catch (NumberFormatException e) {
        return false;
      }
      boolean isValidNumber = (x >= 0 && x <= 255);
      if (!isValidNumber) { return false; }
    }

    return true;
  }

  private int[] fromString(String s) {
    if (!validate(s)) {
      throw new IllegalArgumentException("Invalid ip address");
    }

    String[] sDigits = s.split("\\.");
    int[] digits = new int[4];

    for (int i = 0; i < sDigits.length; i++) {
      digits[i] = Integer.parseInt(sDigits[i]);
    }

    return digits;
  }

  @Override
  public boolean isPrivate() {
    /*
     * Private IP address list:
     *
     * 10.0.0.0/8
     * 172.16.0.0/12 (172.16.0.0 – 172.31.255.255)
     * 192.168.0.0/16 ()
     */
    boolean privateCaseOne = (this.digitOne == 10);
    boolean privateCaseTwo = (this.digitOne == 172) && (this.digitTwo >= 16 && this.digitTwo <= 31);
    boolean privateCaseThree = (this.digitOne == 192) && (this.digitTwo == 168);

    /*
     * Other non-public IP addresses:
     *
     * 0.0.0.0/8
     * 224.0.0.0/8 - 255.0.0.0/8
     */
    boolean privateCaseFour = this.digitOne == 0;
    boolean privateCaseFive = (this.digitOne >= 244 && this.digitOne <= 255);

    return privateCaseOne || privateCaseTwo || privateCaseThree || privateCaseFour || privateCaseFive;
  }

  @Override
  public InternetProtocolMetadata getMetadata() {
    String starter = API_BASE_URL + this.toString();
    String country = httpReq(starter + "/country");
    String city = httpReq(starter + "/city");
    String asn = httpReq(starter + "/asn");

    return new InternetProtocolMetadata(country, city, Integer.parseInt(asn));
  }

  private String httpReq(String url) {
    HttpClient client = HttpClient.newHttpClient();

    // Define the request
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(url))
      .GET() // Use .POST() or other methods as needed
      .build();

    try {
      // Send the request and receive the response
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      // Output the response
      System.out.println("Status Code: " + response.statusCode());
      return response.body();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String toString() {
    return this.digitOne + "." + this.digitTwo + "." + this.digitThree + "." + this.digitFour;
  }

  // at some point override equals
}
