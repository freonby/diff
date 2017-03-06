package by.tarif.web.databuffer;

import java.io.Serializable;
import java.util.List;

public class EnergoSystem implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private int quarter;
	private boolean workday;
	private boolean holyday;
	private List<Register> list;
	private String nameQuarter;

	public EnergoSystem() {
		super();
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public boolean isWorkday() {
		return workday;
	}

	public void setWorkday(boolean workday) {
		this.workday = workday;
	}

	public boolean isHolyday() {
		return holyday;
	}

	public void setHolyday(boolean holyday) {
		this.holyday = holyday;
	}

	public List<Register> getList() {
		return list;
	}

	public void setList(List<Register> list) {
		this.list = list;
	}

	public String getNameQuarter() {
		return nameQuarter;
	}

	public void setNameQuarter(String nameQuarter) {
		this.nameQuarter = nameQuarter;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float sumConsumptionValue() {
		float sum = 0f;
		for (Register register : this.list) {
			sum += register.getConsumption();
		}
		return sum;
	}

	public float midConsumptionValue() {
		float sum = sumConsumptionValue();
		return sum / 48;
	}

	public float sumConsuptionAbove() {
		float sum = 0f;
		float mid = midConsumptionValue();
		for (Register register : this.list) {
			if (register.getConsumption() >= mid) {
				sum += register.getConsumption();
			}
		}
		return sum;
	}

	public float sumConsuptionLess() {
		float sum = 0f;
		float mid = midConsumptionValue();
		for (Register register : this.list) {
			if (register.getConsumption() < mid) {
				sum += register.getConsumption();
			}
		}
		return sum;
	}

	public float kValue() {
		float kVal = (sumConsuptionAbove() - sumConsuptionLess()) / sumConsumptionValue();
		return kVal;
	}

}
