package by.tarif.web.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import by.tarif.web.databuffer.IntervalStrings;
import by.tarif.web.databuffer.TimeZone;

public class HibDAO implements DAO {

	private SessionFactory sessionFactory;

	public HibDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<IntervalStrings> getIntervals() {
		@SuppressWarnings("unchecked")
		List<IntervalStrings> list = (List<IntervalStrings>) sessionFactory.getCurrentSession().createCriteria(IntervalStrings.class).list();
		return list;
	}

	@Override
	@Transactional
	public List<TimeZone> getZone() {
		@SuppressWarnings("unchecked")
		List<TimeZone> list = (List<TimeZone>) sessionFactory.getCurrentSession().createCriteria(TimeZone.class).list();
		return list;
	}

}
