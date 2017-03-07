package by.dunaenergo.tarif;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import by.dunaenergo.tarif.dao.DAO;
import by.dunaenergo.tarif.databuffer.Abonent;
import by.dunaenergo.tarif.databuffer.EnergoSystem;
import by.dunaenergo.tarif.databuffer.IntervalStrings;
import by.dunaenergo.tarif.databuffer.Register;
import by.dunaenergo.tarif.databuffer.Result;
import by.dunaenergo.tarif.databuffer.Tarif;
import by.dunaenergo.tarif.databuffer.TimeZone;
import by.dunaenergo.tarif.utility.JSONParser;

@Controller
public class MainController {
	@Inject
	private DAO hibdao;

	// private static final Logger logger =
	// LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {
		List<TimeZone> timeZone = hibdao.getZone();
		List<IntervalStrings> stringsList = hibdao.getIntervals();
		session.setAttribute("sliderValue", 0);
		session.setAttribute("energyType", 1);
		session.setAttribute("relative", true);
		session.setAttribute("day", 1);
		session.setAttribute("month", 1);
		session.setAttribute("year", 2017);
		session.setAttribute("timeZone", timeZone);
		session.setAttribute("stringsList", stringsList);
		ModelAndView model = new ModelAndView();
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
	public ModelAndView userPage(HttpSession session) {
		// EnergoSystem es = Util.init();
		// hibdao.addEnergoSystem(es);
		// Abonent ab = Util.initAbonentCsv(2017, 1, "user");
		// hibdao.addAbonent(ab);
		EnergoSystem es = hibdao.getEnergoSystem(1, true, false);
		Abonent ab = hibdao.getAbonent("user");
		Tarif tarif = hibdao.getTarif(1);
		int DD = (Integer) session.getAttribute("day");
		int MM = (Integer) session.getAttribute("month");
		int YYYY = (Integer) session.getAttribute("year");
		Result result = new Result(ab, es, tarif, YYYY, MM, DD);
		result.init(DD);
		if ((Boolean) session.getAttribute("relative")) {
			List<Register> graphdata = result.getRelativeAbonent();
			int daysCount = result.getDaysCount();
			session.setAttribute("abonent", ab);
			session.setAttribute("result", result);
			session.setAttribute("es", es);
			session.setAttribute("tarif", tarif);
			session.setAttribute("daysCount", daysCount);
			session.setAttribute("graphdata", graphdata);
			ModelAndView model = new ModelAndView();
			model.setViewName("userPage");
			model.addObject("bodyClass", "cm-no-transition cm-1-navbar");

			return model;
		}
		List<Register> graphdata = result.getInputAbonent();
		int daysCount = result.getDaysCount();
		session.setAttribute("abonent", ab);
		session.setAttribute("result", result);
		session.setAttribute("es", es);
		session.setAttribute("tarif", tarif);
		session.setAttribute("daysCount", daysCount);
		session.setAttribute("graphdata", graphdata);

		ModelAndView model = new ModelAndView();
		model.setViewName("userPage");
		model.addObject("bodyClass", "cm-no-transition cm-1-navbar");

		return model;

	}

	@RequestMapping(value = "/calcPage", method = RequestMethod.GET)
	public ModelAndView calcPage(HttpSession session) {
		Result result = (Result) session.getAttribute("result");
		List<Register> abList = result.getInputAbonent();
		List<Register> esList = result.getInputEnergoSystem();
		ModelAndView model = new ModelAndView();
		model.setViewName("calcPage");
		model.addObject("bodyClass", "cm-no-transition cm-2-navbar");
		model.addObject("abList", abList);
		model.addObject("esList", esList);
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
		List<IntervalStrings> stringsList = (List<IntervalStrings>) session.getAttribute("stringsList");
		Result result = (Result) session.getAttribute("result");
		if ((Boolean) session.getAttribute("relative")) {
			List<Register> graphdata = result.getRelativeAbonent();
			session.setAttribute("graphdata", graphdata);
			String json30 = JSONParser.energoSystemJson(graphdata, result.getRelativeEnergoSystem(), stringsList, "#2F2F4C", "#C7504F");
			return json30;
		}
		List<Register> graphdata = (List<Register>) session.getAttribute("graphdata");
		String json30 = JSONParser.energoSystemJson(graphdata, result.getRelativeEnergoSystem(), stringsList, "#2F2F4C", "#C7504F");
		return json30;
	}

	@RequestMapping(value = "/slider", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSlider(HttpSession session, @RequestParam String value) {
		session.setAttribute("sliderValue", value);
		return "";
	}

	@RequestMapping(value = "/nav", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String goNav(HttpSession session, @RequestParam String direction) {
		if (direction.equals("prev")) {
			Result result = (Result) session.getAttribute("result");
			int DD = (Integer) session.getAttribute("day");
			if (DD <= 1) {

				return result.json();

			}
			DD -= 1;
			session.setAttribute("day", DD);
			result.init(DD);
			if ((Boolean) session.getAttribute("relative")) {
				List<Register> graphdata = result.getRelativeAbonent();
				session.setAttribute("graphdata", graphdata);
				session.setAttribute("result", result);
				return result.json();
			}
			List<Register> graphdata = result.getInputAbonent();
			session.setAttribute("graphdata", graphdata);
			session.setAttribute("result", result);
			return result.json();
		}
		if (direction.equals("next")) {
			Result result = (Result) session.getAttribute("result");
			int DD = (Integer) session.getAttribute("day");
			int daysCount = (Integer) session.getAttribute("daysCount");
			if (DD >= daysCount) {

				return result.json();

			}
			DD += 1;
			session.setAttribute("day", DD);
			result.init(DD);
			if ((Boolean) session.getAttribute("relative")) {
				List<Register> graphdata = result.getRelativeAbonent();
				session.setAttribute("graphdata", graphdata);
				session.setAttribute("result", result);
				return result.json();
			}
			List<Register> graphdata = result.getInputAbonent();
			session.setAttribute("graphdata", graphdata);
			session.setAttribute("result", result);
			return result.json();
		}
		if (direction.equals("begin")) {
			Result result = (Result) session.getAttribute("result");
			int DD = 1;
			session.setAttribute("day", DD);
			if (result != null) {
				result.init(DD);
				if ((Boolean) session.getAttribute("relative")) {
					List<Register> graphdata = result.getRelativeAbonent();
					session.setAttribute("graphdata", graphdata);
					session.setAttribute("result", result);
					return result.json();
				}
				List<Register> graphdata = result.getInputAbonent();
				session.setAttribute("graphdata", graphdata);
				session.setAttribute("result", result);
				return result.json();
			}

		}
		if (direction.equals("end")) {
			Result result = (Result) session.getAttribute("result");
			int daysCount = (Integer) session.getAttribute("daysCount");
			session.setAttribute("day", daysCount);
			result.init(daysCount);
			if ((Boolean) session.getAttribute("relative")) {
				List<Register> graphdata = result.getRelativeAbonent();
				session.setAttribute("graphdata", graphdata);
				session.setAttribute("result", result);
				return result.json();
			}
			List<Register> graphdata = result.getInputAbonent();
			session.setAttribute("graphdata", graphdata);
			session.setAttribute("result", result);
			return result.json();
		}
		return "";

	}

}
