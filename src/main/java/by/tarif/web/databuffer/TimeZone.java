package by.tarif.web.databuffer;

import java.io.Serializable;
import java.util.List;

public class TimeZone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8930018472683110564L;
	private long id;
	private int code;
	private String hexColor;
	private String name;

	public TimeZone() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getHexColor() {
		return hexColor;
	}

	public void setHexColor(String hexColor) {
		this.hexColor = hexColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String findByCode(List<TimeZone> list, Integer code) {
		String find = "";
		for (TimeZone timeZone : list) {
			if (timeZone.getCode() == code) {
				find = timeZone.getHexColor();
				return find;
			}
		}
		return find;
	}
}
