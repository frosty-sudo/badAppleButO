package badApple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.*; 


import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

import org.json.simple.parser.*;

public class Main {
	
	public static int mod(int x, int y) {
		return (int) (x - y*Math.floor(x/y));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {

		TimeUnit time = TimeUnit.MILLISECONDS;

	
		
		
        Object o = new JSONParser().parse(new FileReader("C:\\Users\\ME\\PycharmProjects\\VideoProcessing\\data\\dataset.json"));

		JSONArray a = (JSONArray) o;
		
//		for (int frame = 1; frame < a.size(); frame++) {			
//			JSONArray frameArray = ((JSONArray) a.get(frame));
//			for (int r = 0; r < 49; r++) {
//				for (int i = 0; i < 64; i++) {
//					if (((Long) frameArray.get(r * 64 + i)).intValue() == 0) {					
//						System.out.print(" O");
//					} else {
//						System.out.print("  ");
//					}
//				}
//				System.out.println("");
//			}
//			
//			time.sleep(80);
//			
//			for (int i = 0; i < 4; i++) {
//				
//				System.out.println("");
//			}
//		}
		
		for (int frame = 1; frame < a.size(); frame++) {
			String frameString = "";
			JSONArray frameArray = ((JSONArray) a.get(frame));
			for (int i = 0; i < frameArray.size(); i++) {
				if (((Long)frameArray.get(i)).intValue() == 0) {
					frameString += " O";
				} else {
					frameString += "  ";
				}
				if (mod(i, 64) == 0) {
					frameString += "\n";
				}
			}
			time.sleep(20);
			System.out.println(frameString);
		}
	}

}
