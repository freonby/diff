package by.tarif.web.dao;

import java.util.List;

import by.tarif.web.databuffer.Abonent;
import by.tarif.web.databuffer.EnergoSystem;
import by.tarif.web.databuffer.IntervalStrings;
import by.tarif.web.databuffer.Tarif;
import by.tarif.web.databuffer.TimeZone;

public interface DAO {

	public List<IntervalStrings> getIntervals();

	public List<TimeZone> getZone();

	public EnergoSystem getEnergoSystem(int quarter, boolean workday, boolean holyday);

	public void addEnergoSystem(EnergoSystem es);

	public void updateEnergoSystem(EnergoSystem es);

	public void deleteEnergoSystem(EnergoSystem es);

	public Abonent getAbonent(String userLogin);

	public void addAbonent(Abonent abonent);

	public void updateAbonent(Abonent abonent);

	public void deleteAbonent(Abonent abonent);

	public Tarif getTarif(long tarif_id);

	public void addTarif(Tarif tarif);

	public void updateTarif(Tarif tarif);

	public void deleteTarif(Tarif tarif);

}
