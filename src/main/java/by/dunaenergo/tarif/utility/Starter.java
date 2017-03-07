package by.dunaenergo.tarif.utility;

import by.dunaenergo.tarif.databuffer.Abonent;

public class Starter {

	public static void main(String[] args) {
		Abonent ab = Util.initAbonentCsv(2017, 1, "user");
		System.out.println(ab);

	}

}
