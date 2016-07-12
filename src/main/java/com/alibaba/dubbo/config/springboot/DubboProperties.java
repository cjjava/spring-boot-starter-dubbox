package com.alibaba.dubbo.config.springboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ModuleConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * Java代码的Dubbo配置
 * 
 * @author 陈均
 *
 */
@ConfigurationProperties(prefix = "dubbo")
public class DubboProperties {
	protected static Log log = LogFactory.getLog(DubboProperties.class);
	/**
	 * 应用配置，用于配置当前应用信息，不管该应用是提供者还是消费者。
	 */
	protected ApplicationConfig application;
	/**
	 * 注册中心配置，用于配置连接注册中心相关信息。
	 */
	protected RegistryConfig registry;
	/**
	 * 协议配置，用于配置提供服务的协议信息，协议由提供方指定，消费方被动接受。
	 */
	protected ProtocolConfig protocol;
	/**
	 * 提供方的缺省值，当ProtocolConfig和ServiceConfig某属性没有配置时，采用此缺省值，可选。
	 */
	protected ProviderConfig provider;
	/**
	 * 模块配置，用于配置当前模块信息，可选。
	 */
	protected ModuleConfig module;
	/**
	 * 监控中心配置，用于配置连接监控中心相关信息，可选。
	 */
	protected MonitorConfig monitor;

	public DubboProperties() {
		log.info("-----初始化dubbo默认配置信息------");
		protocol = new ProtocolConfig("dubbo");
		protocol.setSerialization("hessian2");
		registry = new RegistryConfig("zookeeper://127.0.0.1:2181");
		provider = new ProviderConfig();
		module = new ModuleConfig();
		monitor = new MonitorConfig();
	}

	public ApplicationConfig getApplication() {
		return application;
	}

	public void setApplication(ApplicationConfig application) {
		this.application = application;
	}

	public RegistryConfig getRegistry() {
		return registry;
	}

	public void setRegistry(RegistryConfig registry) {
		this.registry = registry;
	}

	public ProtocolConfig getProtocol() {
		return protocol;
	}

	public void setProtocol(ProtocolConfig protocol) {
		this.protocol = protocol;
	}

	public ProviderConfig getProvider() {
		return provider;
	}

	public void setProvider(ProviderConfig provider) {
		this.provider = provider;
	}

	public ModuleConfig getModule() {
		return module;
	}

	public void setModule(ModuleConfig module) {
		this.module = module;
	}

	public MonitorConfig getMonitor() {
		return monitor;
	}

	public void setMonitor(MonitorConfig monitor) {
		this.monitor = monitor;
	}

}
