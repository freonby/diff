package by.dunaenergo.tarif.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import by.dunaenergo.tarif.databuffer.IntervalStrings;
import by.dunaenergo.tarif.databuffer.ItemConsumption;
import by.dunaenergo.tarif.databuffer.ItemTarifConsumption;
import by.dunaenergo.tarif.databuffer.Register;
import by.dunaenergo.tarif.databuffer.TimeZone;

public class JSONParser {

	public static String to48Json(List<Register> listRegisters, List<TimeZone> timeZone, List<IntervalStrings> stringsList) {
		if (listRegisters.size() == 0) {
			return "";
		}
		ArrayList<ItemConsumption> list = new ArrayList<ItemConsumption>();
		ItemConsumption item = null;
		Date date = null;
		for (Register reg : listRegisters) {
			double consumption = reg.getConsumption();
			int intervalNumber = reg.getIntervalNumber();
			double readout = reg.getReadout();
			date = reg.getDate();
			Object[] strings = IntervalStrings.findByInterval(stringsList, intervalNumber);
			String intervalName = (String) strings[0];
			String color = TimeZone.findByCode(timeZone, (Integer) strings[1]);
			item = new ItemConsumption(intervalName, (float) consumption, color, readout, date);
			list.add(item);
		}
		int correctSize = 48;

		if (list.size() < correctSize) {

			for (int i = list.size() + 1; i <= correctSize; i++) {
				Object[] strings = IntervalStrings.findByInterval(stringsList, i);
				String intervalName = (String) strings[0];
				String color = TimeZone.findByCode(timeZone, (Integer) strings[1]);
				item = new ItemConsumption(intervalName, 0f, color, 0d, date);
				list.add(item);
			}
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;

	}

	public static String energoSystemJson(List<Register> listAbonent, List<Register> listEnergoSystem, List<IntervalStrings> stringsList, String abColor, String esColor) {
		if (listAbonent.size() == 0 || listEnergoSystem.size() == 0) {
			return "";
		}
		ArrayList<ItemTarifConsumption> list = new ArrayList<ItemTarifConsumption>();
		ItemTarifConsumption item = null;

		for (Register reg : listAbonent) {
			float consumption = (float) reg.getConsumption();
			int intervalNumber = reg.getIntervalNumber();
			Object[] strings = IntervalStrings.findByInterval(stringsList, intervalNumber);
			String intervalName = (String) strings[0];
			item = new ItemTarifConsumption(intervalName, consumption, 0f, abColor, esColor);
			list.add(item);
		}
		for (int i = 0; i < 48; i++) {
			float consumption = (float) listEnergoSystem.get(i).getConsumption();
			list.get(i).setEsValue(consumption);
		}

		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;

	}

	public static String to24Json(List<Register> listRegisters, List<TimeZone> timeZone, List<IntervalStrings> stringsList) {
		if (listRegisters.size() == 0) {
			return "";
		}

		ArrayList<ItemConsumption> list = new ArrayList<ItemConsumption>();
		ItemConsumption item = null;
		Date date = null;
		int size = listRegisters.size();
		if (size == 0 || size == 1) {
			return "";
		}
		if (size % 2 != 0) {
			size = size - 1;
		}
		for (int i = 0; i < size; i += 2) {
			float consumption1 = (float) listRegisters.get(i).getConsumption();
			float consumption2 = (float) listRegisters.get(i + 1).getConsumption();
			float sum = consumption1 + consumption2;
			int intervalNumber = listRegisters.get(i + 1).getIntervalNumber();
			double readout = listRegisters.get(i + 1).getReadout();
			date = listRegisters.get(i + 1).getDate();
			Object[] strings = IntervalStrings.findByInterval(stringsList, intervalNumber);
			String intervalName = (String) strings[0];
			String color = TimeZone.findByCode(timeZone, (Integer) strings[1]);
			item = new ItemConsumption(intervalName, sum, color, readout, date);
			list.add(item);

		}
		int correctSize = 48;

		if (list.size() < correctSize) {

			for (int i = size + 2; i <= correctSize; i += 2) {
				Object[] strings = IntervalStrings.findByInterval(stringsList, i);
				String intervalName = (String) strings[0];
				String color = TimeZone.findByCode(timeZone, (Integer) strings[1]);
				item = new ItemConsumption(intervalName, 0f, color, 0d, date);
				list.add(item);
			}
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;

	}

}
