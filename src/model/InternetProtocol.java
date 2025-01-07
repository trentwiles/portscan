package model;

import java.io.IOException;

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
   * @throws IllegalStateException if ran on private IP address
   * @throws IllegalStateException upon non-200 status code from upstream API
   * @return basic information, in IP metadata format
   */
  InternetProtocolMetadata getMetadata();
}
