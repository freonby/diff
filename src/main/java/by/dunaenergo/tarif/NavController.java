package by.dunaenergo.tarif;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import by.dunaenergo.tarif.databuffer.Register;
import by.dunaenergo.tarif.databuffer.Result;

@Controller
public class NavController {
	@RequestMapping(value = "/nav", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String goNav(HttpSession session, @RequestParam String direction) {
		Result result = (Result) session.getAttribute("result");
		if (direction.equals("prev")) {
			List<Register> graphdata = result.getRelativeAbonent();
			session.setAttribute("graphdata", graphdata);
			int DD = (Integer) session.getAttribute("day");
			if (DD <= 1) {

				return result.json();

			}
			DD -= 1;
			session.setAttribute("day", DD);
			result.init(DD);
			if ((Boolean) session.getAttribute("relative")) {
				graphdata = result.getRelativeAbonent();
				session.setAttribute("graphdata", graphdata);
				session.setAttribute("result", result);
				return result.json();
			}
			graphdata = result.getInputAbonent();
			session.setAttribute("graphdata", graphdata);
			session.setAttribute("result", result);
			return result.json();
		}
		if (direction.equals("next")) {
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
