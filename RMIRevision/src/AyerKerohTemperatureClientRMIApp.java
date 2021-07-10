import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import ftmk.rmi.sensor.TemperatureSensor;

public class AyerKerohTemperatureClientRMIApp {

	public static void main(String[] args) {
		try {
			
			Registry rmiRegistry = LocateRegistry.getRegistry();
			TemperatureSensor sensorAyerKeroh = (TemperatureSensor)rmiRegistry.lookup("SensorAyerKeroh");
			int temp = sensorAyerKeroh.getTemperature();
			
			System.out.println("\n\nCurrent temperature in Ayer Keroh is " + temp + " Celcius");	
			System.out.println("\nToday is Saturday. Hence, the temperature is " + sensorAyerKeroh.getTemperatureByDay("Saturday"));
			System.out.println("\n\n\t\t\t======================Ayer Keroh======================\n\n\t\t     Weekly average for temperature in Ayer Keroh is " 
					+ String.format("%.2f", sensorAyerKeroh.getAverageTemp()) + " Celcius");
					System.out.println("\n\t\t\t====================================================");
			
		}catch(RemoteException | NotBoundException ex) {
			ex.printStackTrace();
		}

	}

}
