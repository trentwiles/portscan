package model;

public class InternetProtocolAddress implements InternetProtocol {
  private int digitOne;
  private int digitTwo;
  private int digitThree;
  private int digitFour;

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
}
