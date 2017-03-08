package by.dunaenergo.tarif.databuffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Regulator {
	private List<Register> inputAbonent;
	private List<Register> resultRegulatedAbonent;
	private int[] maxPeriod = { 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
	private int[] nightPeriod = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 42, 43, 44, 45, 46, 47, 48 };
	private int regulValue;

	public Regulator(List<Register> inputAbonent, int[] maxPeriod, int[] nightPeriod, int regulValue) {
		super();
		this.inputAbonent = inputAbonent;
		this.resultRegulatedAbonent = new ArrayList<Register>();
		this.maxPeriod = maxPeriod;
		this.nightPeriod = nightPeriod;
		this.regulValue = regulValue;
	}

	public Regulator(List<Register> inputAbonent, int regulValue) {
		super();
		this.inputAbonent = inputAbonent;
		this.resultRegulatedAbonent = new ArrayList<Register>();
		this.regulValue = regulValue;
	}

	public void runAlgoritm() {
		resultRegulatedAbonent.clear();
		List<Register> maxListRegisters = new ArrayList<Register>();
		List<Register> resultMaxListRegisters = new ArrayList<Register>();
		List<Register> nightListRegisters = new ArrayList<Register>();
		List<Register> resultNightListRegisters = new ArrayList<Register>();
		List<Register> temp = new LinkedList<Register>();
		temp.addAll(inputAbonent);
		for (int i = 0; i < maxPeriod.length; i++) {
			int maxInterval = maxPeriod[i];
			Register find = inputAbonent.get(maxInterval - 1);
			temp.remove(find);
			maxListRegisters.add(find);
		}
		for (int i = 0; i < nightPeriod.length; i++) {
			int nightInterval = nightPeriod[i];
			Register find = inputAbonent.get(nightInterval - 1);
			temp.remove(find);
			nightListRegisters.add(find);
		}
		float sumMax = 0f;
		float delta = 0f;
		for (Register register : maxListRegisters) {
			sumMax += register.getConsumption();
		}
		float valueConsumption = sumMax * regulValue / 100;
		for (Register register : maxListRegisters) {
			delta = (float) (register.getConsumption() / sumMax);
			float k = 1 - delta;
			float dValue = valueConsumption * k;
			float newMaxValue = (float) (register.getConsumption() - dValue);
			resultMaxListRegisters.add(new Register(register.getIntervalNumber(), newMaxValue, 1, 0, new Date()));
		}
		float valueToNight = valueConsumption / nightListRegisters.size();
		for (Register register : nightListRegisters) {
			float newNightValue = (float) (register.getConsumption() + valueToNight);
			resultNightListRegisters.add(new Register(register.getIntervalNumber(), newNightValue, 1, 0, new Date()));
		}

		resultRegulatedAbonent.addAll(resultNightListRegisters);
		resultRegulatedAbonent.addAll(resultMaxListRegisters);
		resultRegulatedAbonent.addAll(temp);
		Collections.sort(resultRegulatedAbonent, new Comparator<Register>() {
			public int compare(Register r1, Register r2) {
				return r1.getIntervalNumber() - r2.getIntervalNumber();
			}
		});

	}

	public List<Register> getInputAbonent() {
		return inputAbonent;
	}

	public void setInputAbonent(List<Register> inputAbonent) {
		this.inputAbonent = inputAbonent;
	}

	public List<Register> getResultRegulatedAbonent() {
		return resultRegulatedAbonent;
	}

	public void setResultRegulatedAbonent(List<Register> resultRegulatedAbonent) {
		this.resultRegulatedAbonent = resultRegulatedAbonent;
	}

	public int[] getMaxPeriod() {
		return maxPeriod;
	}

	public void setMaxPeriod(int[] maxPeriod) {
		this.maxPeriod = maxPeriod;
	}

	public int[] getNightPeriod() {
		return nightPeriod;
	}

	public void setNightPeriod(int[] nightPeriod) {
		this.nightPeriod = nightPeriod;
	}

	public int getRegulValue() {
		return regulValue;
	}

	public void setRegulValue(int regulValue) {
		this.regulValue = regulValue;
	}

}
