package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JSONModel {
	
	public boolean write_dat(JSONObject FinalObject, String fileTitle) {
		
		// TODO Auto-generated method stub
		String fileName =  fileTitle+ ".json";
		
		File tmpDir = new File(fileName);
	    boolean exists = tmpDir.exists();
	    if (exists) 
	    {	
	    System.out.println("/var/tmp exists");
	    return exists;
	    }
	    else
	    {
		
		try (FileWriter file = new FileWriter(fileName))
		{
			file.write(FinalObject.toString());
			file.flush();
			System.out.println(FinalObject);
			return false;
		} catch (IOException e) {
			
			
			e.printStackTrace();
			return false;
		}
		
	}

	}
	}


