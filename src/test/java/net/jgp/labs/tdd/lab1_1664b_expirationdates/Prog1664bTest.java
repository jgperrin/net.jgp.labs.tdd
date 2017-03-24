package net.jgp.labs.tdd.lab1_1664b_expirationdates;

import static org.junit.Assert.*;

import org.junit.Test;

public class Prog1664bTest {

	@Test
	public void testEncode() {
		Prog1664b app = new Prog1664b();
		String coded = app.encode("9/14/83");
		assertEquals("ok", coded, "IQTN");
	}

	@Test
	public void testDecode() {
		Prog1664b app = new Prog1664b();
		String coded = app.decode("IQTN");
		assertEquals("ok", coded, "9/14/1983");
	}

	@Test
	public void testProcess0() {
		Prog1664b app = new Prog1664b();
		for (int i = 71; i < 96; i++) {
			String toTest = "1/1/" + i;
			String res = "1/1/19" + i;
			String coded = app.encode(toTest);
			assertEquals("ok", app.decode(coded), res);
		}
	}

	@Test
	public void testProcess1() {
		Prog1664b app = new Prog1664b();
		int dm[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int m = 1; m < 13; m++) {
			for (int d = 1; d <= dm[m-1]; d++) {
				for (int y = 71; y <= 96; y++) {
					String toTest = m + "/" + d + "/" + y;
					String res = m + "/" + d + "/19" + y;
					System.out.print("Testing: " + toTest);
					String coded = app.encode(toTest);
					System.out.println(" code: " + coded);
					assertEquals("ok", app.decode(coded), res);
				}
			}
		}
	}
}
