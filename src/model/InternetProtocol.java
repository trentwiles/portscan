package model;

/**
 * Java representation of an IP address.
 */
public interface InternetProtocol {

  /**
   * Is the IP object an internal/private IP address?
   * @return true if internal, false if public
   */
  boolean isPrivate();

  /**
   * Fetches basic information for an IP address from an external API.
   * @return basic information, in IP metadata format
   */
  InternetProtocolMetadata getMetadata();
}
