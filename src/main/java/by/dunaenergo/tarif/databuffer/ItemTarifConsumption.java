package by.dunaenergo.tarif.databuffer;

public class ItemTarifConsumption {
	private String interval;
	private float abValue;
	private float esValue;
	private String abColor;
	private String esColor;

	public ItemTarifConsumption(String interval, float abValue, float esValue, String abColor, String esColor) {
		super();
		this.interval = interval;
		this.abValue = abValue;
		this.esValue = esValue;
		this.abColor = abColor;
		this.esColor = esColor;
	}

	public ItemTarifConsumption() {
		super();
		this.interval = "";
		this.abValue = 0f;
		this.esValue = 0f;
		this.abColor = "";
		this.esColor = "";
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public float getAbValue() {
		return abValue;
	}

	public void setAbValue(float abValue) {
		this.abValue = abValue;
	}

	public float getEsValue() {
		return esValue;
	}

	public void setEsValue(float esValue) {
		this.esValue = esValue;
	}

	public String getAbColor() {
		return abColor;
	}

	public void setAbColor(String abColor) {
		this.abColor = abColor;
	}

	public String getEsColor() {
		return esColor;
	}

	public void setEsColor(String esColor) {
		this.esColor = esColor;
	}
}
