package services;

import java.util.Set;

import javax.ejb.Remote;

@Remote
public interface Config {
	
	Set<String> getConfigNames();

	void setConfig(String key, String value);

	String getValue(String key);
}
