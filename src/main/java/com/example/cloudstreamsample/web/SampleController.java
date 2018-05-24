package com.example.cloudstreamsample.web;

import com.example.cloudstreamsample.source.KafkaProducer;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SampleController {

	private static final Logger log = LoggerFactory.getLogger(SampleController.class);

	@Autowired
	private KafkaProducer kafkaProducer;

	@PostMapping(value = "/hoge", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void hoge(@RequestBody HogeRequest request) {

		log.info(request.toString());

		kafkaProducer.send(request);
	}

	public static class HogeRequest {

		@JsonProperty("id")
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "HogeRequest{" +
					"id='" + id + '\'' +
					'}';
		}
	}
}
