package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvise {

	@ExceptionHandler(Exception.class)
	public String handleDrror(HttpServletRequest request){
		return "error";
	}
	
}
