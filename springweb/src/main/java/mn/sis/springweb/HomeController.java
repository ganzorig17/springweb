package mn.sis.springweb;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import mn.sis.menu.Menu;
import mn.sis.menu.Modul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private CustomerDao customerDao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ExceptionHandler({SpringException.class})
	public ModelAndView home(Locale locale, Model model) {
		
//		try {
			logger.info("Welcome home! The client locale is {}.", locale);

			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
					DateFormat.LONG, locale);

			String formattedDate = dateFormat.format(date);

			model.addAttribute("serverTime", formattedDate);
			String arr[] = new String[] {"Mongol","Uls"};
			
			Student studentArr[] = new Student[10];
			for(int ix =0; ix < 10; ix ++)
			{
				Student student = new Student(10,"Ganzorig" + ix, ix);
				studentArr[ix] = student;
			}
			
			
			
			//String json = "[{\"modulPkid\":1,\"modulName\":\"Ð�Ð´Ð¼Ð¸Ð½\",\"menuList\":[{\"menuPkId\":1,\"menuName\":\"Ð�Ð´Ð¼Ð¸Ð½\",\"tileName\":\"\"},{\"menuPkId\":3,\"menuName\":\"ÐœÐµÐ½ÑŽ Ð°Ð´Ð¼Ð¸Ð½\",\"tileName\":\"\"},{\"menuPkId\":21,\"menuName\":\"Ð­Ñ€Ñ… Ð·Ð¾Ñ…Ð¸Ñ†ÑƒÑƒÐ»Ð°Ð»Ñ‚\",\"tileName\":\"\"},{\"menuPkId\":26,\"menuName\":\"Ð­Ñ€Ñ… Ð¾Ð»Ð³Ð¾Ñ…\",\"tileName\":\"\"},{\"menuPkId\":27,\"menuName\":\"Ð¡Ò¯Ð»Ð¶Ñ�Ñ�\",\"tileName\":\"\"},{\"menuPkId\":20,\"menuName\":\"Ð¥ÑƒÐ²Ð¸Ð¹Ð½ Ñ�Ñ€Ñ…\",\"tileName\":\"\"}]},{\"modulPkid\":2,\"modulName\":\"Ð›Ð°Ð±Ð¾Ñ€Ð°Ñ‚Ð¾Ñ€Ð¸\",\"menuList\":[{\"menuPkId\":25,\"menuName\":\"Ð¢Ó©Ñ…Ó©Ó©Ñ€Ó©Ð¼Ð¶\",\"tileName\":\"\"}]},{\"modulPkid\":3,\"modulName\":\"Ð­Ð¼Ð½Ñ�Ð»Ñ�Ð³\",\"menuList\":[{\"menuPkId\":28,\"menuName\":\"Ð­Ð�Ð�Ð¡\",\"tileName\":\"\"},{\"menuPkId\":29,\"menuName\":\"Ð–Ð°Ð³Ñ�Ð°Ð°Ð»Ñ‚\",\"tileName\":\"\"},{\"menuPkId\":30,\"menuName\":\"Ð¢Ò¯Ò¯Ñ…\",\"tileName\":\"\"},{\"menuPkId\":31,\"menuName\":\"ÐžÐ½Ð¾Ñˆ\",\"tileName\":\"\"}]}]";
			ObjectMapper mapper = new ObjectMapper();
			//System.out.println(mapper.writeValueAsString(customerDao.findModelMenu()));
			//Modul [] modulList = mapper.readValue(json, Modul[].class);
			
			//System.out.println(modulList[0].getMenuList().get(0).getMenuName());
//			model.addAttribute("menu", mapper.writeValueAsString(customerDao.findModelMenu()));
			
//		} catch (Exception e) {
//			throw new SpringException(e.getMessage());
//		}

		return new ModelAndView("homeTile", "menu", customerDao.findModelMenu());
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student,
			ModelMap model) {
		System.out.println("START-------------");
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());

		return "result";
	}
	
	

}
