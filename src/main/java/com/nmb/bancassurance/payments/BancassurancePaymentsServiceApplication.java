package com.nmb.bancassurance.payments;

import com.nmb.bancassurance.shared.components.BaseServiceComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class BancassurancePaymentsServiceApplication {
	@Value("${bancassurance.kafka.url}")
	private String kafkaUrl;

	public static void main(String[] args) {
		SpringApplication.run(BancassurancePaymentsServiceApplication.class, args);
	}

	@Bean
	protected BaseServiceComponent baseServiceComponent() {
		return BaseServiceComponent.builder()
				.kafkaUrl(kafkaUrl)
				.build();
	}
}
