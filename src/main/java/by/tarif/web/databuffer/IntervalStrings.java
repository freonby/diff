package by.tarif.web.databuffer;

import java.io.Serializable;
import java.util.List;

public class IntervalStrings implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1056501445389137392L;
	private long id;
	private int intervalNumber;
	private String intervalName;
	private int codeTimeZone;

	public IntervalStrings() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIntervalNumber() {
		return intervalNumber;
	}

	public void setIntervalNumber(int intervalNumber) {
		this.intervalNumber = intervalNumber;
	}

	public String getIntervalName() {
		return intervalName;
	}

	public void setIntervalName(String intervalName) {
		this.intervalName = intervalName;
	}

	public int getCodeTimeZone() {
		return codeTimeZone;
	}

	public void setCodeTimeZone(int codeTimeZone) {
		this.codeTimeZone = codeTimeZone;
	}

	public static Object[] findByInterval(List<IntervalStrings> list, int numberInterval) {
		Object[] find = new Object[2];
		for (IntervalStrings st : list) {
			if (st.getIntervalNumber() == numberInterval) {
				find[0] = st.getIntervalName();
				find[1] = st.getCodeTimeZone();
				return find;
			}
		}
		return find;
	}

}
