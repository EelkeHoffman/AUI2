package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonStructure;

import server.Conversation;
import server.Handler;

public class InputController implements Handler {
	private  String name = "";
	private JsonStructure data;
	
	
	
	public JsonObject testf() throws FileNotFoundException {
		
		FileReader fr = new FileReader("test.json");
		 BufferedReader br = new BufferedReader(fr);
		 JsonObject obj = (JsonObject) br;
		 return obj;
	}
	public void handle(Conversation conversation) {
		
		 
		
		 JsonObject jsonIn = (JsonObject) conversation.getRequestBodyAsJSON();
		String tijdname = jsonIn.getString("user");
		 JsonObjectBuilder objBuilder = Json.createObjectBuilder();
		 if(tijdname.equals("test")) {
			 
			 
			 objBuilder.add("message", name);
			
			 
			 
			 
		 } else if(tijdname.equals("done")) {name = "";}
		 
		 
		 else { name = name+ tijdname + "\n";
		 objBuilder.add("message", "POST");}
		
		 data = conversation.getRequestBodyAsJSON();
		 System.out.println(name);
		 conversation.sendJSONMessage(objBuilder.build().toString());
		 
		}
	
}
