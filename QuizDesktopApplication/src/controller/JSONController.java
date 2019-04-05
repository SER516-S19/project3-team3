package controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.JSONModel;

@SuppressWarnings("unused")
public class JSONController {

	
	public boolean write_data_to_model(JSONObject FinalObject, String fileTitle) {
		// TODO Auto-generated method stub
		JSONModel m =new JSONModel();
		boolean File_exits=m.write_dat(FinalObject,fileTitle);
		return File_exits;
	}



}