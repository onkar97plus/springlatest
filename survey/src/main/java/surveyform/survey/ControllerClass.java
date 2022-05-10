package surveyform.survey;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "*")
@RestController
public class ControllerClass {

    @Autowired
	private SurveyDao dao; 

	@RequestMapping("/")
	public String home() {
		return "hi.jsp";
	}

	@PostMapping("/accept")
	public ModelAndView accept(@RequestBody SurveyModel sm){

		
		System.out.println(sm.getInterest());

		ModelAndView mv = new ModelAndView("success.jsp");
		

		dao.save(sm);
		return mv;

	} 

	@RequestMapping("/fetch")
	public List<SurveyModel> fetch(){
		return dao.findAll();
	}

}
