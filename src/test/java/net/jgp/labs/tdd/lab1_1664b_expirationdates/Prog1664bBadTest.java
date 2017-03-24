package net.jgp.labs.tdd.lab1_1664b_expirationdates;

import static org.junit.Assert.*;

import org.junit.Test;

public class Prog1664bBadTest {

	@Test
	public void testEncode() {
		Prog1664bBad app = new Prog1664bBad();
		String coded = app.encode("9/14/83");
		assertEquals("ok", coded, "IQTN");
	}

	@Test
	public void testDecode() {
		Prog1664bBad app = new Prog1664bBad();
		String coded = app.decode("IQTN");
		assertEquals("ok", coded, "9/14/1983");
	}

	@Test
	public void testProcess() {
		Prog1664bBad app = new Prog1664bBad();
		for (int i = 71; i < 96; i++) {
			String toTest = "1/1/" + i;
			String res = "1/1/19" + i;
			String coded = app.encode(toTest);
			assertEquals("ok", app.decode(coded), res);
		}
	}
}
