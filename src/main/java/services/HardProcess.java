package services;

import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface HardProcess {

	Future<String> process(String value);
}
