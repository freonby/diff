package by.dunaenergo.tarif.databuffer;

import java.io.Serializable;
import java.util.List;

public class YearBuffer implements Serializable {

	private static final long serialVersionUID = -5942563442162797247L;
	private long id_year;
	private int YYYY;
	private List<MonthBuffer> monthsList;

	public YearBuffer() {
		super();
	}

	public long getId_year() {
		return id_year;
	}

	public void setId_year(long id_year) {
		this.id_year = id_year;
	}

	public int getYYYY() {
		return YYYY;
	}

	public void setYYYY(int yYYY) {
		YYYY = yYYY;
	}

	public List<MonthBuffer> getMonthsList() {
		return monthsList;
	}

	public void setMonthsList(List<MonthBuffer> monthsList) {
		this.monthsList = monthsList;
	}

}
