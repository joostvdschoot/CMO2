package com.cmo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;

import com.cmo.controller.base.CreditLineBaseController;

@RestController
@PropertySource("classpath:${configfile.path}/CMO.properties")
@RequestMapping(value="${endpoint.api}", headers = "Accept=application/json")
public class CreditLineController extends CreditLineBaseController {

	//OVERRIDE HERE YOUR CUSTOM CONTROLLER

}
