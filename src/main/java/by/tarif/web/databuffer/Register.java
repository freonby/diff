package by.tarif.web.databuffer;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Register implements Serializable {

	private static final long serialVersionUID = 1L;
	private long register_id;
	private long energyMeter_id;
	private long fider_id;
	private String energyMeter_number;
	private int energyType;
	private Date date;
	private int intervalNumber;
	private double consumption;
	private double readout;

	public Register(int intervalNumber, double consumption, int energyType, double readout, Date date) {
		super();
		this.intervalNumber = intervalNumber;
		this.consumption = consumption;
		this.energyType = energyType;
		this.readout = readout;
		this.date = date;
	}

	public Register() {
		super();
	}

	public long getRegister_id() {
		return register_id;
	}

	public void setRegister_id(long register_id) {
		this.register_id = register_id;
	}

	public long getEnergyMeter_id() {
		return energyMeter_id;
	}

	public void setEnergyMeter_id(long energyMeter_id) {
		this.energyMeter_id = energyMeter_id;
	}

	public long getFider_id() {
		return fider_id;
	}

	public void setFider_id(long fider_id) {
		this.fider_id = fider_id;
	}

	public String getEnergyMeter_number() {
		return energyMeter_number;
	}

	public void setEnergyMeter_number(String energyMeter_number) {
		this.energyMeter_number = energyMeter_number;
	}

	public int getIntervalNumber() {
		return intervalNumber;
	}

	public void setIntervalNumber(int intervalNumber) {
		this.intervalNumber = intervalNumber;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	public double getReadout() {
		return readout;
	}

	public void setReadout(double readout) {
		this.readout = readout;
	}

	public int getEnergyType() {
		return energyType;
	}

	public void setEnergyType(int energyType) {
		this.energyType = energyType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date dateConverter(String inputdata) {

		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
		try {
			date = (java.util.Date) format.parse(inputdata);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// java.sql.Date date_sql = new java.sql.Date(date.getTime());
		return date;

	}

	public static List<Register> filterRegistersByEnergyMeter(List<Register> allList, String meterNumber) {
		if (allList != null || meterNumber != null) {
			List<Register> filterList = new ArrayList<Register>();
			for (Register register : allList) {
				if (register.getEnergyMeter_number().equals(meterNumber))
					filterList.add(register);
			}
			return filterList;
		}
		return null;

	}

	public static List<Register> filterRegistersByEnergyType(List<Register> allList, int energyType) {
		if (allList != null) {
			List<Register> filterList = new ArrayList<Register>();
			for (Register register : allList) {
				if (register.getEnergyType() == energyType)
					filterList.add(register);
			}
			return filterList;
		}
		return null;

	}

	public static List<Register> filterRegistersByEnergyTypeAndMeterNumber(List<Register> allList, String meterNumber, int energyType) {
		if (allList != null) {
			List<Register> filterList = new ArrayList<Register>();
			for (Register register : allList) {
				if (register.getEnergyType() == energyType & register.getEnergyMeter_number().equals(meterNumber))
					filterList.add(register);
			}
			return filterList;
		}
		return null;

	}

	public static double findMaxConsumption(List<Register> list) {
		double max = 0d;
		if (list != null) {
			for (Register register : list) {
				if (register.getConsumption() >= max)
					max = register.getConsumption();
			}
			return max;
		}
		return max;

	}

}
