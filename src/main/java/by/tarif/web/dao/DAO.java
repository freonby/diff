package by.tarif.web.dao;

import java.util.List;

import by.tarif.web.databuffer.IntervalStrings;
import by.tarif.web.databuffer.TimeZone;

public interface DAO {

	public List<IntervalStrings> getIntervals();

	public List<TimeZone> getZone();

}
