package Ejercicio3_clase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HiloArchivo extends Thread  {
	public static final String CYAN = "\u001b[36m";
	public static final String RED = "\u001b[31m";
	public static final String MAG = "\u001b[35m";
	

	public void run() {
		
		String nombreHilo = this.getName();
		switch(nombreHilo) {
			case "HILOArchivoEj3_1":
				System.out.println(CYAN+this.getName()+" ejecuta");
			break;
			case "HILOArchivoEj3_2":
				System.out.println(MAG+this.getName()+" ejecuta");
			break;
			default:
				System.out.println(RED+this.getName()+" ejecuta");
		}
			   try {
					FileWriter fw = new FileWriter("./"+nombreHilo+".txt");
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int inx=0; inx <= 10000; inx ++) {
						bw.write(inx+", ");					
					}
					
					bw.close(); fw.close();
					
					
				} catch(IOException e) {
					System.out.println(e.getMessage());
				}
		   
			if(this.getName().equals("demonio"))
				System.out.println(RED+"fin del :"+this.getName());
			else
				System.out.println(CYAN+"fin del :"+this.getName());
	}
}
