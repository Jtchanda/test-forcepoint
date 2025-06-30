package com.nmb.bancassurance.payments;

import com.nmb.bancassurance.shared.components.BaseServiceComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@RequiredArgsConstructor
@ComponentScan(basePackages = {"bancassurance.securitylibrary", "com.nmb.bancassurance.payments"})
public class BancassurancePaymentsServiceApplication {
	private final KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BancassurancePaymentsServiceApplication.class, args);
	}

	@Bean
	protected BaseServiceComponent baseServiceComponent() {
		return BaseServiceComponent.builder()
				.kafkaTemplate(kafkaTemplate)
				.build();
	}
}
