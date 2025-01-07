package model;

public class InternetProtocolAddress {

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
}
