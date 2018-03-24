package controller;

import java.io.File;
import server.JSONFileServer;

public class Application {
	public static void main(String[] args) {
		JSONFileServer server = new JSONFileServer(new File("webapp"), 8887);
		server.start();
		InputController controller = new InputController();
		server.registerHandler("/example", controller);
	}
	
}