package currency.scommettitoreApp.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import currency.scommettitoreApp.model.Currencylayer;
import currency.scommettitoreApp.service.PrincipalService;
import currency.scommettitoreApp.service.urlService;

@RestController
public class ScommesseController {
	@Autowired
		
	@RequestMapping(value = "/live", method = RequestMethod.GET)
	public ResponseEntity<Object> live() throws ClientProtocolException, IOException {
		return new ResponseEntity<>(Currencylayer.getJson(urlService.geturl("0")),HttpStatus.OK);
			
		}
	}
