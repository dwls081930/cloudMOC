package com.isu.moc.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error"; // configure 에서 Redirect 될 path

    @RequestMapping(value = PATH)
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));
        model.addAttribute("code", status.toString());
        model.addAttribute("msg", httpStatus.getReasonPhrase());
        model.addAttribute("timestamp", new Date());
        return "error/error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}
