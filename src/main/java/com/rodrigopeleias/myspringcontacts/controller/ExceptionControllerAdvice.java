package com.rodrigopeleias.myspringcontacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionControllerAdvice {

    public String exception(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "globalControllerHandler";
    }
}
