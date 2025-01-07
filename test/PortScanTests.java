import model.InternetProtocolAddress;
import model.PortScan;
import org.junit.Assert;
import org.junit.Test;

public class PortScanTests {

  @Test
  public void testOpenPort() {
    Assert.assertFalse(PortScan.isPortOpen(new InternetProtocolAddress("1.1.1.1"), 1234));
    Assert.assertTrue(PortScan.isPortOpen(new InternetProtocolAddress("1.1.1.1"), 80));
  }
}
