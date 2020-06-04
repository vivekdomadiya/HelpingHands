package com.helpingHands.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.helpingHands.Exception.ErrorResponse;

@Controller
public class WhitelableErrorController implements ErrorController {

	@RequestMapping("/error")
	public ModelAndView handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    System.out.println("WhiteLable Error! " +status);
	    
	    ModelAndView mv = new ModelAndView("error.jsp");
	    ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Somthing Went Wrong");
	    
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            error.setMessage("Page not found");
	            error.setStatus(HttpStatus.NOT_FOUND);
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            error.setMessage("Somthing Went Wrong");
	            error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        else if(statusCode == HttpStatus.FORBIDDEN.value()) {
	        	error.setMessage("User Not Allowed To Access");
	        	error.setStatus(HttpStatus.FORBIDDEN);
	        }
	    }
	    mv.addObject("error", error);
	    return mv;
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
