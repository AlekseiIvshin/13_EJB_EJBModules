package services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value = 5, unit = TimeUnit.SECONDS)
public class ConfigBean implements Config {

	// TODO: change map type
	Map<String, String> configurations;

	@PostConstruct
	void init(){
		System.out.println("Constract config bean");
		configurations  = new HashMap<String, String>();
		configurations.put("markCountPerPage", "10");
	}
	
	
	@Lock(LockType.WRITE)
	@Override
	public void setConfig(String key, String value) {
		configurations.put(key, value);
	}

	@Lock(LockType.READ)
	@Override
	public String getValue(String key) {
		return configurations.get(key);
	}


	@Lock(LockType.READ)
	@Override
	public Set<String> getConfigNames() {
		return new HashSet<String>(configurations.keySet());
	}

}
