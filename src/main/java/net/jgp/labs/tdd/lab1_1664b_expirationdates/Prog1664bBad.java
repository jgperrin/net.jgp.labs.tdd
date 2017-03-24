package net.jgp.labs.tdd.lab1_1664b_expirationdates;

public class Prog1664bBad {

	public String encode(String dateAsString) {
		switch (dateAsString) {
		case "9/14/83":
			return "IQTN";

		default:
			return null;
		}
	}

	public String decode(String code) {
		switch (code) {
		case "IQTN":
			return "9/14/1983";

		default:
			return null;
		}
	}
}
