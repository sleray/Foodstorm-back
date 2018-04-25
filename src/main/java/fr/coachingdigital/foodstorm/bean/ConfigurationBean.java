package fr.coachingdigital.foodstorm.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

public class ConfigurationBean {

	@Bean
	public MBeanExporter exporter() {
		final MBeanExporter exporter = new MBeanExporter();
		exporter.setAutodetect(true);
		exporter.setExcludedBeans("dataSource");
		return exporter;
	}
}
