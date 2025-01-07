import model.InternetProtocolAddress;
import org.junit.Assert;
import org.junit.Test;

public class InternetProtocolTests {

  @Test
  public void testValidateIP() {
    Assert.assertTrue(InternetProtocolAddress.validate("1.1.1.1"));
    Assert.assertTrue(InternetProtocolAddress.validate("0.0.0.0"));
    Assert.assertTrue(InternetProtocolAddress.validate("255.255.255.255"));
    Assert.assertTrue(InternetProtocolAddress.validate("93.29.100.4"));
    Assert.assertFalse(InternetProtocolAddress.validate(null));
    Assert.assertFalse(InternetProtocolAddress.validate(""));
    Assert.assertFalse(InternetProtocolAddress.validate("abcdf"));
    Assert.assertFalse(InternetProtocolAddress.validate("0.0.0"));
    Assert.assertFalse(InternetProtocolAddress.validate("1.2.256.4"));
    Assert.assertFalse(InternetProtocolAddress.validate("9.9.9.9.9"));
    Assert.assertFalse(InternetProtocolAddress.validate("73.73.73. "));
  }

}
