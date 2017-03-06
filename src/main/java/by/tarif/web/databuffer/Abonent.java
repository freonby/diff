package by.tarif.web.databuffer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Abonent implements Serializable {

	private static final long serialVersionUID = -9196128916974513326L;
	private long abonent_id;
	private String userLogin;
	private String companyName;
	private String address;
	private String email;
	private String phone;
	private String unp;
	private String okpo;
	private String bankName;
	private String bankAdress;
	private String bankCode;
	private String bankAccount;
	private String contactPerson;
	private String comment;
	private boolean workday;
	private boolean holyday;
	private boolean active;
	private List<YearBuffer> yearList;

	public Abonent() {
		super();
	}

	public long getAbonent_id() {
		return abonent_id;
	}

	public void setAbonent_id(long abonent_id) {
		this.abonent_id = abonent_id;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUnp() {
		return unp;
	}

	public void setUnp(String unp) {
		this.unp = unp;
	}

	public String getOkpo() {
		return okpo;
	}

	public void setOkpo(String okpo) {
		this.okpo = okpo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAdress() {
		return bankAdress;
	}

	public void setBankAdress(String bankAdress) {
		this.bankAdress = bankAdress;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getComment() {
		return comment;
	}

	public boolean isActive() {
		return active;
	}

	public List<YearBuffer> getYearList() {
		return yearList;
	}

	public void setYearList(List<YearBuffer> yearList) {
		this.yearList = yearList;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public List<Register> findRegistersBy(int YYYY, int MM, int DD) {
		List<Register> result = new ArrayList<Register>();
		for (YearBuffer yearBuffer : yearList) {
			if (yearBuffer.getYYYY() == YYYY) {
				List<MonthBuffer> monthsList = yearBuffer.getMonthsList();
				for (MonthBuffer monthBuffer : monthsList) {
					if (monthBuffer.getMonthNumber() == MM) {
						List<DayBuffer> daysList = monthBuffer.getDaysList();
						for (DayBuffer dayBuffer : daysList) {
							if (dayBuffer.getDayNumber() == DD) {
								return result = dayBuffer.getRegisters();
							}
						}
					}
				}
			}

		}
		return result;

	}

	public int daysCount(int YYYY, int MM) {
		int result = 0;
		for (YearBuffer yearBuffer : yearList) {
			if (yearBuffer.getYYYY() == YYYY) {
				List<MonthBuffer> monthsList = yearBuffer.getMonthsList();
				for (MonthBuffer monthBuffer : monthsList) {
					if (monthBuffer.getMonthNumber() == MM) {
						List<DayBuffer> daysList = monthBuffer.getDaysList();
						result = daysList.size();
					}
				}
			}

		}
		return result;
	}

	public float sumConsumptionValue(List<Register> list) {
		float sum = 0f;
		for (Register register : list) {
			sum += register.getConsumption();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Информация об абоненте:\n");
		sb.append("Годовых периодов: " + yearList.size() + "\n");
		for (YearBuffer yearBuffer : yearList) {
			sb.append("Год: " + yearBuffer.getYYYY() + "\n");
			List<MonthBuffer> mlist = yearBuffer.getMonthsList();
			for (MonthBuffer monthBuffer : mlist) {
				sb.append("Месяц: " + monthBuffer.getMonthNumber() + "\n");
				List<DayBuffer> dlist = monthBuffer.getDaysList();
				for (DayBuffer dayBuffer : dlist) {
					sb.append("День: " + dayBuffer.getDayNumber() + " Интервалов: " + dayBuffer.getRegisters().size() + "\n");
				}
			}

		}
		return sb.toString();
	}

}
