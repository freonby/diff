package by.tarif.web.databuffer;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Result {
	private Abonent abonent;
	private EnergoSystem es;
	private Tarif tarif;
	private List<Register> inputAbonent;
	private List<Register> inputEnergoSystem;
	private List<Register> relativeAbonent;
	private List<Register> relativeEnergoSystem;
	private int day;
	private int month;
	private int year;
	private int daysCount;
	private float sumConsumptionAbonent;
	private float sumConsumptionEs;
	private float delta;
	private float alpha;
	private float sutTarif;
	private float pay;

	public Result() {
		super();
	}

	public Result(Abonent ab, EnergoSystem es, Tarif tarif, int YYYY, int MM, int DD) {
		super();
		this.abonent = ab;
		this.es = es;
		this.tarif = tarif;
		this.day = DD;
		this.month = MM;
		this.year = YYYY;
		this.inputAbonent = ab.findRegistersBy(year, month, day);
		this.daysCount = ab.daysCount(year, month);
		this.inputEnergoSystem = es.getList();
		this.relativeAbonent = new ArrayList<Register>();
		this.relativeEnergoSystem = new ArrayList<Register>();
		this.sumConsumptionAbonent = ab.sumConsumptionValue(inputAbonent);
		this.sumConsumptionEs = es.sumConsumptionValue();
		relativeValues();
		this.delta = delta(listDelta());
		this.alpha = alpha();
		this.sutTarif = sutTarif();
		this.pay = pay();
	}

	public Abonent getAbonent() {
		return abonent;
	}

	public void setAbonent(Abonent abonent) {
		this.abonent = abonent;
	}

	public EnergoSystem getEs() {
		return es;
	}

	public void setEs(EnergoSystem es) {
		this.es = es;
	}

	public Tarif getTarif() {
		return tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	public List<Register> getInputAbonent() {
		return inputAbonent;
	}

	public void setInputAbonent(List<Register> inputAbonent) {
		this.inputAbonent = inputAbonent;
	}

	public List<Register> getInputEnergoSystem() {
		return inputEnergoSystem;
	}

	public void setInputEnergoSystem(List<Register> inputEnergoSystem) {
		this.inputEnergoSystem = inputEnergoSystem;
	}

	public List<Register> getRelativeAbonent() {
		return relativeAbonent;
	}

	public void setRelativeAbonent(List<Register> relativeAbonent) {
		this.relativeAbonent = relativeAbonent;
	}

	public List<Register> getRelativeEnergoSystem() {
		return relativeEnergoSystem;
	}

	public void setRelativeEnergoSystem(List<Register> relativeEnergoSystem) {
		this.relativeEnergoSystem = relativeEnergoSystem;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(int daysCount) {
		this.daysCount = daysCount;
	}

	public float getSumConsumptionAbonent() {
		return sumConsumptionAbonent;
	}

	public void setSumConsumptionAbonent(float sumConsumptionAbonent) {
		this.sumConsumptionAbonent = sumConsumptionAbonent;
	}

	public float getSumConsumptionEs() {
		return sumConsumptionEs;
	}

	public void setSumConsumptionEs(float sumConsumptionEs) {
		this.sumConsumptionEs = sumConsumptionEs;
	}

	public float getDelta() {
		return delta;
	}

	public void setDelta(float delta) {
		this.delta = delta;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public float getSutTarif() {
		return sutTarif;
	}

	public void setSutTarif(float sutTarif) {
		this.sutTarif = sutTarif;
	}

	public float getPay() {
		return pay;
	}

	public void setPay(float pay) {
		this.pay = pay;
	}

	public void relativeValues() {

		for (Register register : inputAbonent) {
			float c = (float) register.getConsumption();
			float unit = (float) (c / sumConsumptionAbonent);
			register.setConsumption(unit);
			relativeAbonent.add(register);
		}
		for (Register register : inputEnergoSystem) {
			float c = (float) register.getConsumption();
			float unit = (float) (c / sumConsumptionEs);
			register.setConsumption(unit);
			relativeEnergoSystem.add(register);
		}

	}

	public List<Float> listDelta() {
		List<Float> deltaList = new ArrayList<Float>();

		for (int i = 0; i < 48; i++) {
			float unitEs = (float) relativeEnergoSystem.get(i).getConsumption();
			float unitAb = (float) relativeAbonent.get(i).getConsumption();
			if (unitEs >= tarif.getpMid()) {
				float delta = unitEs - unitAb;
				deltaList.add(new Float(delta));
			}
			float delta = unitAb - unitEs;
			deltaList.add(new Float(delta));
		}
		return deltaList;

	}

	public float delta(List<Float> deltaValues) {
		float delta = 0f;
		for (Float d : deltaValues) {
			delta += d;
		}
		return delta;
	}

	public float alpha() {
		float kVal = es.kValue();
		float alpha = delta - kVal;
		return alpha;
	}

	public float sutTarif() {
		float tMin = tarif.gettMin();
		float tMax = tarif.gettMax();
		float tE = tMin + (tMax - tMin) * (1 - alpha) / 2;
		return tE;
	}

	public float pay() {
		float pay = sutTarif * sumConsumptionAbonent / 2;
		return pay;
	}

	public String json() {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(abonent.getCompanyName());
		list.add(day);
		list.add(daysCount);
		list.add(sutTarif);
		list.add(alpha);
		list.add(pay);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [day=");
		builder.append(day);
		builder.append(", month=");
		builder.append(month);
		builder.append(", year=");
		builder.append(year);
		builder.append(", daysCount=");
		builder.append(daysCount);
		builder.append(", sumConsumptionAbonent=");
		builder.append(sumConsumptionAbonent);
		builder.append(", sumConsumptionEs=");
		builder.append(sumConsumptionEs);
		builder.append(", delta=");
		builder.append(delta);
		builder.append(", alpha=");
		builder.append(alpha);
		builder.append(", sutTarif=");
		builder.append(sutTarif);
		builder.append(", pay=");
		builder.append(pay);
		builder.append("]");
		return builder.toString();
	}

}
