package by.tarif.web.utility;

import by.tarif.web.databuffer.Abonent;

public class Starter {

	public static void main(String[] args) {
		Abonent ab = Util.initAbonentCsv(2017, 1, "user");
		System.out.println(ab);

	}

}
