package com.javasampleapproach.rabbitmq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.rabbitmq.publisher.Publisher;

@RestController
public class WebController {

	@Autowired
	Publisher publisher;

	@RequestMapping("/send")
	public String sendMsg(@RequestParam("msg") String msg) {
		for (int i = 0; i < 2000; i++) {
			publisher.produceMsg(msg);
		}
		return "Done";
	}
}
