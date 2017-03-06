package by.tarif.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.tarif.web.dao.DAO;
import by.tarif.web.databuffer.Abonent;
import by.tarif.web.databuffer.EnergoSystem;
import by.tarif.web.databuffer.IntervalStrings;
import by.tarif.web.databuffer.Register;
import by.tarif.web.databuffer.Result;
import by.tarif.web.databuffer.Tarif;
import by.tarif.web.databuffer.TimeZone;
import by.tarif.web.utility.JSONParser;

@Controller
public class MainController {
	@Inject
	private DAO hibdao;
	// private static final Logger logger =
	// LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView home(HttpSession session) {
		List<TimeZone> timeZone = hibdao.getZone();
		List<IntervalStrings> stringsList = hibdao.getIntervals();
		session.setAttribute("energyType", 1);
		session.setAttribute("day", 1);
		session.setAttribute("month", 1);
		session.setAttribute("year", 2017);
		session.setAttribute("timeZone", timeZone);
		session.setAttribute("stringsList", stringsList);
		session.setAttribute("intervalType", 30);
		ModelAndView model = new ModelAndView();
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
	public ModelAndView userPage(HttpSession session) {
		EnergoSystem es = hibdao.getEnergoSystem(1, true, false);
		Abonent ab = hibdao.getAbonent("user");
		Tarif tarif = hibdao.getTarif(1);
		int DD = (Integer) session.getAttribute("day");
		int MM = (Integer) session.getAttribute("month");
		int YYYY = (Integer) session.getAttribute("year");
		Result result = new Result(ab, es, tarif, YYYY, MM, DD);
		result.init(DD);
		List<Register> graphdata = result.getInputAbonent();
		int daysCount = result.getDaysCount();
		session.setAttribute("abonent", ab);
		session.setAttribute("result", result);
		session.setAttribute("es", es);
		session.setAttribute("tarif", tarif);
		session.setAttribute("daysCount", daysCount);
		session.setAttribute("graphdata", graphdata);

		// EnergoSystem es = Util.init();
		// hibdao.addEnergoSystem(es);
		// Abonent ab = Util.initAbonentCsv(2017, 1, "user");
		// hibdao.addAbonent(ab);
		ModelAndView model = new ModelAndView();
		model.setViewName("userPage");
		model.addObject("bodyClass", "cm-no-transition cm-1-navbar");

		return model;

	}

	@RequestMapping(value = "/calcPage", method = RequestMethod.GET)
	public ModelAndView calcPage(HttpSession session) {

		ModelAndView model = new ModelAndView();
		model.setViewName("calcPage");
		model.addObject("bodyClass", "cm-no-transition cm-2-navbar");

		return model;

	}

	@RequestMapping(value = "/graphPage", method = RequestMethod.GET)
	public ModelAndView graphPage(HttpSession session) {

		ModelAndView model = new ModelAndView();
		model.setViewName("graphPage");
		model.addObject("bodyClass", "cm-no-transition cm-2-navbar");

		return model;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/gson", method = RequestMethod.GET)
	@ResponseBody
	public String goJson(HttpSession session) {
		List<TimeZone> timeZone = (List<TimeZone>) session.getAttribute("timeZone");
		List<IntervalStrings> stringsList = (List<IntervalStrings>) session.getAttribute("stringsList");
		List<Register> graphdata = (List<Register>) session.getAttribute("graphdata");
		int intervalType = (Integer) session.getAttribute("intervalType");
		switch (intervalType) {
		case 30:
			String json30 = JSONParser.to48Json(graphdata, timeZone, stringsList);
			return json30;
		case 60:
			String json60 = JSONParser.to24Json(graphdata, timeZone, stringsList);
			return json60;

		}

		return "";
	}

	@RequestMapping(value = "/next", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String goNext(HttpSession session) {

		Result result = (Result) session.getAttribute("result");
		int DD = (Integer) session.getAttribute("day");
		int daysCount = (Integer) session.getAttribute("daysCount");
		if (DD >= daysCount) {

			return result.json();

		}
		DD += 1;
		session.setAttribute("day", DD);
		result.init(DD);
		List<Register> graphdata = result.getInputAbonent();
		session.setAttribute("graphdata", graphdata);
		session.setAttribute("result", result);
		return result.json();

	}

	@RequestMapping(value = "/prev", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String goPrev(HttpSession session) {

		Result result = (Result) session.getAttribute("result");
		int DD = (Integer) session.getAttribute("day");
		if (DD <= 1) {

			return result.json();

		}
		DD -= 1;
		session.setAttribute("day", DD);
		result.init(DD);
		List<Register> graphdata = result.getInputAbonent();
		session.setAttribute("graphdata", graphdata);
		session.setAttribute("result", result);
		return result.json();

	}

}
