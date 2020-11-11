package com.postjms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.postjms.model.JmsDetails;

@Controller
@RequestMapping({ "/postJmsMessage" })
public class HomeController {
	@Value("${local.jms.url}")
	String localUrl;
	@Value("${dev.jms.url}")
	String devUrl;
	@Value("${si.jms.url}")
	String siUrl;
	@Value("${qa.jms.url}")
	String qaUrl;
	@Value("${uat.jms.url}")
	String uatUrl;
	@Value("${hf.jms.url}")
	String hfUrl;
	@Value("${prod.jms.url}")
	String prodUrl;
	@Value("${dr.jms.url}")
	String drUrl;
	
	@Resource
	List<String> environmentList;
	
	@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String viewJmsDetails(Map<String, Object> model) {
		JmsDetails jmsDetails = new JmsDetails();
		model.put("jmsDetails", jmsDetails);

		/*List<String> environmentList = new ArrayList<String>();
		environmentList.add("LOCAL");
		environmentList.add("DEV");
		environmentList.add("SI");
		environmentList.add("QA");
		environmentList.add("UAT");
		environmentList.add("HF");*/
		model.put("environmentList", environmentList);

		List<String> queueOrTopicSelector = new ArrayList();
		queueOrTopicSelector.add("QUEUE");
		queueOrTopicSelector.add("TOPIC");
		model.put("queueOrTopicSelector", queueOrTopicSelector);

		return "jmsDetails";
	}

	@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public String user(@ModelAttribute("jmsDetails") JmsDetails jmsDetails) {
		String environment = jmsDetails.getEnvironment();
		System.out.println("environment: " + environment);
		System.out.println("queue/topic selector: " + jmsDetails.getQueueOrTopic());
		System.out.println("queue/topic name: " + jmsDetails.getName());
		System.out.println("username: " + jmsDetails.getUsername());
		System.out.println("password " + jmsDetails.getPassword());
		System.out.println("content: " + jmsDetails.getContent());
		System.out.println("queueOrTopic: " + jmsDetails.getQueueOrTopic());

		String url = "";
		switch (environment) {
		case "LOCAL":
			url = this.localUrl;
			break;
		case "DEV":
			url = this.devUrl;
			break;
		case "SI":
			url = this.siUrl;
			break;
		case "QA":
			url = this.qaUrl;
			break;
		case "UAT":
			url = this.uatUrl;
			break;
		case "HF":
			url = this.hfUrl;
		case "PROD":
			url = this.prodUrl;
		case "DR":
			url = this.drUrl;
			break;
		}
		System.out.println("url: " + url);
		Connection connection = null;
		try {
			Object conFactory = new ActiveMQConnectionFactory(url);

			connection = ((ConnectionFactory) conFactory).createConnection(jmsDetails.getUsername(),
					jmsDetails.getPassword());
			connection.start();

			Session session = connection.createSession(false, 1);
			Destination destination = null;
			if ("QUEUE".equals(jmsDetails.getQueueOrTopic())) {
				destination = session.createQueue(jmsDetails.getName());
			}
			if ("TOPIC".equals(jmsDetails.getQueueOrTopic())) {
				destination = session.createTopic(jmsDetails.getName());
			}
			MessageProducer producer = session.createProducer(destination);

			TextMessage message = session.createTextMessage(jmsDetails.getContent());

			producer.send(message);
			System.out.println("Sent message '" + message.getText() + "'");

			return "postJMSSuccess";
		} catch (Exception e) {
			e.printStackTrace();
			jmsDetails.setErrorMessage(e.getMessage());
			return "postJMSFailure";
		} finally {
			try {
				if (null != connection) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "postJMSFailure";
			}
		}
	}
}
