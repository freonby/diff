package by.dunaenergo.tarif.databuffer;

import java.io.Serializable;
import java.util.List;

public class DayBuffer implements Serializable {

	private static final long serialVersionUID = 2944300253618250751L;
	private long id_day;
	private int dayNumber;
	private List<Register> registers;

	public DayBuffer() {
		super();
	}

	public long getId_day() {
		return id_day;
	}

	public void setId_day(long id_day) {
		this.id_day = id_day;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}

}
