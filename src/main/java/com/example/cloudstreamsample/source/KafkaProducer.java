package com.example.cloudstreamsample.source;

import com.example.cloudstreamsample.web.SampleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class KafkaProducer {

	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private Source source;

	public void send(SampleController.HogeRequest hogeRequest) {

		source.output().send(MessageBuilder.withPayload(hogeRequest).build());
	}
}
