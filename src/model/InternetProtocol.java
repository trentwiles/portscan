package model;

public interface InternetProtocol {

  /**
   * Is the IP object an internal/private IP address?
   * @return true if internal, false if public
   */
  boolean isPrivate();
}
