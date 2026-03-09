package com.example.adria_gate_way;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdriaGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdriaGateWayApplication.class, args);
	}
	
	@Bean
	DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
	        ReactiveDiscoveryClient rdc,
	        DiscoveryLocatorProperties dlp) {

	    return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}
}
