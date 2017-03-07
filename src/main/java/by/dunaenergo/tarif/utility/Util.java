package by.dunaenergo.tarif.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.dunaenergo.tarif.databuffer.Abonent;
import by.dunaenergo.tarif.databuffer.DayBuffer;
import by.dunaenergo.tarif.databuffer.EnergoSystem;
import by.dunaenergo.tarif.databuffer.MonthBuffer;
import by.dunaenergo.tarif.databuffer.Register;
import by.dunaenergo.tarif.databuffer.YearBuffer;

public class Util {
	public static EnergoSystem init() {
		EnergoSystem es = new EnergoSystem();
		List<Register> list = new ArrayList<Register>();
		es.setNameQuarter("I квартал");
		es.setQuarter(1);
		es.setHolyday(false);
		es.setWorkday(true);
		File f = new File("e:/Java Spring/SpringTarif/energoData.csv");
		BufferedReader br = null;
		int count = 0;
		try {
			br = new BufferedReader(new FileReader(f));
			while (br.ready()) {
				list.add(new Register(count + 1, new Double(br.readLine()), 1, 0d, new Date()));
				count++;
			}
			System.out.println("Добавлено " + count + " регистров");
			System.out.println("Размер буффера" + list.size());
			for (Register register : list) {
				System.out.println(register.getConsumption());
			}
			es.setList(list);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return es;
	}

	public static Abonent initAbonentCsv(int YYYY, int MM, String login) {
		Abonent ab = new Abonent();
		ab.setCompanyName("Тестовый абонент");
		ab.setUserLogin(login);
		YearBuffer yb = new YearBuffer();
		yb.setYYYY(YYYY);
		List<YearBuffer> yearList = new ArrayList<YearBuffer>();
		List<MonthBuffer> monthList = new ArrayList<MonthBuffer>();
		List<DayBuffer> daysList = new ArrayList<DayBuffer>();
		List<Register> list = null;
		MonthBuffer month = new MonthBuffer();
		month.setMonthNumber(MM);
		DayBuffer day = null;
		File f = new File("e:/Java Spring/SpringTarif/data.csv");
		BufferedReader br = null;
		int count = 0;
		String input = "";
		String[] array = null;
		try {
			br = new BufferedReader(new FileReader(f));
			while (br.ready()) {
				input = br.readLine();
				count++;
				input.trim();
				array = input.split(";");
				list = new ArrayList<Register>();
				day = new DayBuffer();
				for (int i = 0; i < array.length; i++) {
					list.add(new Register(i + 1, new Double(array[i].replace(",", ".")), 1, 0d, new Date()));
				}
				day.setDayNumber(count);
				day.setRegisters(list);
				daysList.add(day);
			}
			month.setDaysList(daysList);
			monthList.add(month);
			yb.setMonthsList(monthList);
			yearList.add(yb);
			ab.setYearList(yearList);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ab;
	}
}
