package by.dunaenergo.tarif.databuffer;

import java.io.Serializable;
import java.util.List;

public class MonthBuffer implements Serializable {

	private static final long serialVersionUID = 1457772065985694288L;
	private long id_month;
	private int monthNumber;
	private List<DayBuffer> daysList;

	public MonthBuffer() {
		super();
	}

	public long getId_month() {
		return id_month;
	}

	public void setId_month(long id_month) {
		this.id_month = id_month;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	public List<DayBuffer> getDaysList() {
		return daysList;
	}

	public void setDaysList(List<DayBuffer> daysList) {
		this.daysList = daysList;
	}
}
