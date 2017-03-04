package by.tarif.web.databuffer;

import java.util.Date;

import by.tarif.web.utility.DateParser;

public class ItemConsumption {
	private String interval;
	private float value;
	private String color;
	private float readout;
	private String date;

	public ItemConsumption(String interval, float value, String color, double readout, Date date) {
		super();
		this.interval = interval;
		this.value = value;
		this.color = color;
		this.readout = (float) readout;
		this.date = DateParser.convertDateTo(date);

	}

	public ItemConsumption() {
		super();
		this.interval = "";
		this.value = 0f;
		this.readout = 0f;
		this.color = "";
		this.date = "";

	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getReadout() {
		return readout;
	}

	public void setReadout(float readout) {
		this.readout = readout;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
