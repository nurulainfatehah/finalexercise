package ftmk.rmi.sensor.manager;

import java.util.HashMap;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {

	public TemperatureSensorManager() throws RemoteException {
		super();
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}
	
	public HashMap getHashMapTemp(){
		HashMap<String, Integer> temp = new HashMap<>();
		temp.put("Monday", 27);
		temp.put("Tuesday", 31);
		temp.put("Wednesday", 32);
		temp.put("Thursday", 33);
		temp.put("Friday", 34);
		temp.put("Saturday", 38);
		temp.put("Sunday", 39);
		
		return temp;
	}
	
	@Override
	public int getTemperatureByDay(String day) throws RemoteException {
		
		int temp = 0;
		HashMap getTemp = getHashMapTemp();
		temp = (int)getTemp.get(day);
		
		return temp;
	}
	
	public double getAverageTemp() throws RemoteException{
		double avg = 0.0;
		HashMap<String, Integer> getTemp = getHashMapTemp();
		
		for(int temp: getTemp.values()) {
			avg = avg + temp;
		}
		
		return avg/getTemp.size();
	}
}
