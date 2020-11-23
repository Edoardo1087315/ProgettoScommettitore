package currency.scommettitoreApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScommesseController {
	@Autowired
		
	@RequestMapping(value = "/live", method = RequestMethod.GET)
	public ResponseEntity<Object> live(/*@RequestParam (name ="currencies") String currencies */){
			//return new ResponseEntity<>(PrincipalService.LiveRequest(urlService.geturl(currencies)),HttpStatus.OK);
    	//HttpGet get = new HttpGet("http://api.currencylayer.com/live?access_key=61a81621eef28b86edb01f125def3bfb");
			return new ResponseEntity<>("ciao",HttpStatus.OK);
			
		}
	}
