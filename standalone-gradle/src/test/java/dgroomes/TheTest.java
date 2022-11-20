package dgroomes;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TheTest {

  @Test
  void thisWillSucceed() {
    System.out.println("Hello from 'TheTest.thisWillSucceed()'");
    assertEquals(1, 1);
  }

  @Test
  void thisWillFail() {
    System.out.println("Hello from 'TheTest.thisWillFail()'");
    assertEquals(0, 1);
  }
}
