package by.dunaenergo.tarif.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import by.dunaenergo.tarif.databuffer.Abonent;
import by.dunaenergo.tarif.databuffer.EnergoSystem;
import by.dunaenergo.tarif.databuffer.IntervalStrings;
import by.dunaenergo.tarif.databuffer.Tarif;
import by.dunaenergo.tarif.databuffer.TimeZone;

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

	@Override
	@Transactional
	public EnergoSystem getEnergoSystem(int quarter, boolean workday, boolean holyday) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EnergoSystem.class);
		criteria.add(Restrictions.eq("quarter", quarter));
		criteria.add(Restrictions.eq("workday", workday));
		criteria.add(Restrictions.eq("holyday", holyday));
		EnergoSystem es = (EnergoSystem) criteria.uniqueResult();
		return es;
	}

	@Override
	@Transactional
	public void addEnergoSystem(EnergoSystem es) {
		sessionFactory.getCurrentSession().save(es);

	}

	@Override
	@Transactional
	public void updateEnergoSystem(EnergoSystem es) {
		sessionFactory.getCurrentSession().update(es);

	}

	@Override
	@Transactional
	public void deleteEnergoSystem(EnergoSystem es) {
		sessionFactory.getCurrentSession().delete(es);
	}

	@Override
	@Transactional
	public Abonent getAbonent(String userLogin) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Abonent.class);
		criteria.add(Restrictions.eq("userLogin", userLogin));
		Abonent ab = (Abonent) criteria.uniqueResult();
		return ab;
	}

	@Override
	@Transactional
	public void addAbonent(Abonent abonent) {
		sessionFactory.getCurrentSession().save(abonent);

	}

	@Override
	@Transactional
	public void updateAbonent(Abonent abonent) {
		sessionFactory.getCurrentSession().update(abonent);

	}

	@Override
	@Transactional
	public void deleteAbonent(Abonent abonent) {
		sessionFactory.getCurrentSession().delete(abonent);

	}

	@Override
	@Transactional
	public Tarif getTarif(long tarif_id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tarif.class);
		criteria.add(Restrictions.eq("tarif_id", tarif_id));
		Tarif tarif = (Tarif) criteria.uniqueResult();
		return tarif;
	}

	@Override
	@Transactional
	public void addTarif(Tarif tarif) {
		sessionFactory.getCurrentSession().save(tarif);

	}

	@Override
	@Transactional
	public void updateTarif(Tarif tarif) {
		sessionFactory.getCurrentSession().update(tarif);

	}

	@Override
	@Transactional
	public void deleteTarif(Tarif tarif) {
		sessionFactory.getCurrentSession().delete(tarif);

	}

}
