package mn.sis.springweb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

	@RequestMapping(value = "/restservice", method = RequestMethod.POST)
	public ResponseEntity<Student> update(@RequestBody Student student) {
		
		Student studentObj = new Student();
		studentObj.setName("Ганзориг");
		studentObj.setId(10);
		studentObj.setAge(28);
		 
	    return new ResponseEntity<Student>(studentObj, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/restserviceget", method = RequestMethod.GET)
	public String getrequest(@RequestParam(value="name", defaultValue="World") String name) {
		
	    return name;
	}
}
