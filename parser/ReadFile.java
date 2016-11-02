package parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class ReadFile {
	private BufferedReader br;
	private String path;
	private String sCurrentLine;
	private BufferedWriter wr;
	ReadFile(){
		sCurrentLine = "";
		//path = "F:/virus_project/psiBlast results/mail/";
		path = "F:/virus_project/webserviceRun/inputdone/temp";

		File[] files = new File(path).listFiles();	//pick all the files in this path
int i = 0;
		for (File file : files) {					//for each file in folder
			if (file.isFile()) {
				//run(path+file.getName(),file.getName());			// read all the data in the file to parse
				System.out.print(file.getName()+"\n");
				i++;
				if (i % 10 == 0){
					System.out.print("\n");
				}
			}
		}

	}
	public void run(String f, String file_name){	//reads each file for which the path is given! f is file name

		try{
			br = new BufferedReader(new FileReader(f));
			int rowNo = 0;
			String outpath = "F:/virus_project/psiBlast results/mail/mail_betaFormat/";
			// make new file for parsed data here
			wr = new BufferedWriter(new FileWriter(outpath+file_name));
			int temp = 0;
			

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				rowNo++;
				if (rowNo >= 4){
					if (sCurrentLine.length()>70){
						if (temp == 1){
							wr.newLine();
						}
						temp = 1;
						String parse = sCurrentLine.substring(70,150);
						//System.out.println(parse);
						String new_parse = getvalues(parse);	//parse and get the line in.... 
						wr.write(new_parse);										//... betaware format
																// now enter data in the file made before
					}
				}
			}
			wr.close();
			//System.out.println("\n \n \n");

		}

		catch(IOException e){
			e.printStackTrace();
		}
	}
	private String getvalues(String line){
		int i = 4;								//4 because we pick in sets of 4 bytes, max possible
		int i_back = 0;							// is -100 which is 4 bytes and - is a space
		String segment = "";
		String new_line = " ";
		while (i<=80){
			segment = line.substring(i_back, i);
			segment = segment.trim();

			int c = -1;
			c = Integer.parseInt(segment);
			Float f =0f;
			
			f = ((float)c/100f);
			
			i_back = i;
			i = i+ 4;

			//System.out.print(segment+"\n");
			//new_line.concat(String.format("%.2f", f)+" ");
			String temp = String.format("%.2f", f)+" ";
			new_line = new_line + temp;

			//System.out.print(String.format("%.2f", f)+"\n");

		}
		int len = new_line.length();
		new_line = new_line.substring(1, len-1);		//to cut the useless space at start and end
		System.out.print(new_line+"\n");
		return new_line;
	}

}
