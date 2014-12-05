package services;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value = 5, unit = TimeUnit.SECONDS)
public class ConfigBean implements Config {

	private final static Logger logger = LoggerFactory
			.getLogger(ConfigBean.class);

	Properties configs;

	@PostConstruct
	void init() {
		logger.info("Construct config bean");
		configs = initDefaultConfig();
	}

	@Lock(LockType.WRITE)
	@Override
	public void setConfig(String key, String value) {
		configs.put(key, value);
	}

	@Lock(LockType.READ)
	@Override
	public String getValue(String key) {
		return configs.getProperty(key);
	}

	@Lock(LockType.READ)
	@Override
	public Set<String> getConfigNames() {
		Set<String> rs = new HashSet<String>();
		for (Object o : configs.keySet()) {
			rs.add(o.toString());
		}
		return rs;
	}

	private Properties initDefaultConfig() {
		logger.info("Load default configurations.");
		Properties defaultProp = new Properties();
		defaultProp.put("view.mark.count.perpage", 10);
		return defaultProp;
	}

}
