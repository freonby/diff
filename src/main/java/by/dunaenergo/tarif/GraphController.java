package by.dunaenergo.tarif;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import by.dunaenergo.tarif.databuffer.IntervalStrings;
import by.dunaenergo.tarif.databuffer.Register;
import by.dunaenergo.tarif.databuffer.Result;
import by.dunaenergo.tarif.utility.JSONParser;

@Controller
public class GraphController {
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/gson", method = RequestMethod.GET)
	@ResponseBody
	public String goJson(HttpSession session) {
		List<IntervalStrings> stringsList = (List<IntervalStrings>) session.getAttribute("stringsList");

		Result result = (Result) session.getAttribute("result");

		if ((Boolean) session.getAttribute("relative")) {
			List<Register> graphdata = (List<Register>) session.getAttribute("graphdata");
			String json30 = JSONParser.energoSystemJson(graphdata, result.getRelativeEnergoSystem(), stringsList, "#2F2F4C", "#C7504F");
			System.out.println("вызов gson relative");
			return json30;
		}
		List<Register> graphdata = result.getInputAbonent();
		String json30 = JSONParser.energoSystemJson(graphdata, result.getInputEnergoSystem(), stringsList, "#2F2F4C", "#C7504F");
		// String json30 = JSONParser.to48Json(graphdata, timeZone,
		// stringsList);
		// session.setAttribute("graphdata", graphdata);
		System.out.println("вызов gson normal");
		return json30;
	}

	@RequestMapping(value = "/slider", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSlider(HttpSession session, @RequestParam String value) {
		Integer val = Integer.valueOf(value);
		session.setAttribute("sliderValue", val);
		Result result = (Result) session.getAttribute("result");
		result.setRegulValue(val);
		result.calcRegulValues();
		List<Register> graphdata = result.getRelativeRegulationAbonent();
		session.setAttribute("graphdata", graphdata);
		return result.json();
	}

	@RequestMapping(value = "/balanceGraph", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String balanceGraph(HttpSession session) {
		Result result = (Result) session.getAttribute("result");
		result.alignGraph();
		List<Register> graphdata = result.getRelativeRegulationAbonent();
		session.setAttribute("graphdata", graphdata);
		result.calcAlignValues();
		return result.json();
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatePane(HttpSession session) {
		Result result = (Result) session.getAttribute("result");
		return result.json();
	}

}
