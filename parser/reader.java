package parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class reader {

	public void run (){
		try{
			BufferedReader br;
			String sCurrentLine = "";	
			//br = new BufferedReader(new FileReader("F:/virus_project/psiBlast results/betaware/example/1qj8.prof"));
			br = new BufferedReader(new FileReader("F:/virus_project/psiBlast results/mail/mail_betaFormat/JN698992gi_354996030_ref_AER47379.1_.fsa.prof"));
			int r = 0;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.print(sCurrentLine);									//... betaware format
				// now enter data in the file made before
				//if (r == 147){
					
				//}
				r ++;		
			}
			System.out.print(r);

		}

		//System.out.println("\n \n \n");



		catch(IOException e){
			e.printStackTrace();
		}
	}
}
