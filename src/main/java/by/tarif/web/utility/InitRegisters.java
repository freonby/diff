package by.tarif.web.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import by.tarif.web.databuffer.Register;

public class InitRegisters {
	public static List<Register> init48() {
		List<Register> list = new ArrayList<Register>();
		for (int i = 1; i <= 48; i++) {
			Random rnd = new Random();
			double d = rnd.nextInt(200);
			list.add(new Register(i, d, 1, 0d, new Date()));
		}
		return list;
	}
}
