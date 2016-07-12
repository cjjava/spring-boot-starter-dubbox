package com.alibaba.dubbo.config.springboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;

/**
 * dubbo自动配置信息
 * @author 陈均
 *
 */
@Configuration
@ConditionalOnClass(Exporter.class)
@EnableConfigurationProperties({ DubboProperties.class })
public class DubboAutoConfiguration {
	protected static Log log = LogFactory.getLog(DubboAutoConfiguration.class);
	@Autowired
	private DubboProperties dubboProperties;
	
	@Bean
	public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
		AnnotationBean annotationBean = new AnnotationBean();
		if(null!=packageName || "".equals(packageName)){
			annotationBean.setPackage(packageName);
			log.info("[DubboAutoConfiguration.annotationBean] " + packageName);
		}
		return annotationBean;
	}

	@Bean
	public ApplicationConfig applicationConfig() {
		log.info("[DubboAutoConfiguration.applicationConfig]" + dubboProperties.getApplication());
		return dubboProperties.getApplication();
	}

	@Bean
	public ProtocolConfig protocolConfig() {
		log.info("[DubboAutoConfiguration.protocolConfig]" + dubboProperties.getProtocol());
		return dubboProperties.getProtocol();
	}

	@Bean
	public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
			ProtocolConfig protocolConfig) {
		ProviderConfig providerConfig = dubboProperties.getProvider();
		providerConfig.setApplication(applicationConfig);
		providerConfig.setRegistry(registryConfig);
		providerConfig.setProtocol(protocolConfig);
		log.info("[DubboAutoConfiguration.providerConfig] " + providerConfig);
		return providerConfig;
	}

	@Bean
	public RegistryConfig registryConfig() {
		log.info("[DubboAutoConfiguration.registryConfig] " + dubboProperties.getRegistry());
		return dubboProperties.getRegistry();
	}
	
	@Bean
	public ModuleConfig moduleConfig(ApplicationConfig applicationConfig){
		ModuleConfig moduleConfig = dubboProperties.getModule();
		if(null==moduleConfig.getName()){
			moduleConfig.setName(applicationConfig.getName());
		}
		log.info("[DubboAutoConfiguration.moduleConfig] " + moduleConfig);
		return moduleConfig;
	}
	
	@Bean
	public MonitorConfig monitorConfig(){
		log.info("[DubboAutoConfiguration.monitorConfig] " + dubboProperties.getMonitor());
		return dubboProperties.getMonitor();
	}
	
}