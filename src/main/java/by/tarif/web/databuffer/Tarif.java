package by.tarif.web.databuffer;

public class Tarif {

	private long tarif_id;
	private float tMin;
	private float tMax;
	private float pMid;

	public Tarif() {
		super();
	}

	public float gettMin() {
		return tMin;
	}

	public void settMin(float tMin) {
		this.tMin = tMin;
	}

	public float gettMax() {
		return tMax;
	}

	public void settMax(float tMax) {
		this.tMax = tMax;
	}

	public float getpMid() {
		return pMid;
	}

	public void setpMid(float pMid) {
		this.pMid = pMid;
	}

	public long getTarif_id() {
		return tarif_id;
	}

	public void setTarif_id(long tarif_id) {
		this.tarif_id = tarif_id;
	}

}
