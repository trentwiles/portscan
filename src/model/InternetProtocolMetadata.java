package model;

public class InternetProtocolMetadata {
  private String country;
  private String city;
  private int asn;

  public InternetProtocolMetadata(String country, String city, int asn) {
    if (country == null || city == null) {
      throw new IllegalArgumentException("Country/City cannot be null");
    }
    if (asn <= 0) {
      throw new IllegalArgumentException("ASN cannot be less than or equal to 0");
    }
    this.country = country;
    this.city = city;
    this.asn = asn;
  }

  public String getCountry() {
    return country;
  }

  public String getCity() {
    return city;
  }

  public int getAsn() {
    return asn;
  }

  @Override
  public String toString() {
    return "This IP address is located in " + this.city + ", " + this.country + " and is owned by AS" + this.asn;
  }
}
