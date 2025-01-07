package model;

public class InternetProtocolMetadata {
  private String country;
  private String city;
  private String asn;

  public InternetProtocolMetadata(String country, String city, String asn) {
    if (country == null || city == null || asn == null) {
      throw new IllegalArgumentException("Country/City cannot be null");
    }

    this.country = country.strip();
    this.city = city.strip();
    this.asn = asn.strip();
  }

  public String getCountry() {
    return country;
  }

  public String getCity() {
    return city;
  }

  public String getAsn() {
    return asn;
  }

  @Override
  public String toString() {
    return "This IP address is located in " + this.city + ", " + this.country + " and is owned by " + this.asn;
  }
}
