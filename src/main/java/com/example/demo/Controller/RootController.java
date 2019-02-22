package com.example.demo.Controller;

import javax.servlet.http.HttpSession;

import com.example.demo.Bean.ResBody;
import com.example.demo.Service.NetService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RootController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  NetService netService;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public ResBody hello() {
    logger.info("info");
    logger.warn("warn");
    return netService.resSuccess();
  }

  @RequestMapping(value = "/session", method = RequestMethod.GET) 
  public ResBody checkSession(HttpSession session) {
    if (session.getAttribute("uid") == null) return netService.resSuccess();
    else return netService.resSuccess(session.getAttribute("uid"));
  }
}