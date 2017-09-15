package com.billdiary.ui;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.billdiary.config.SpringFxmlLoader;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

@Controller("NavigationController")
public class NavigationController {
	
	@Autowired
	public HomeController homeController;

	@FXML private void manageProducts(ActionEvent event)
	{
		
		System.out.println(homeController.centerStackpane.getChildren());
		homeController.centerStackpane.setVisible(false);
		//aa.getManagerScene();
		SpringFxmlLoader loader=MainController.getLoader();
		//ResourceBundle bundle = ResourceBundle.getBundle("resources.UIResources");
		AnchorPane a=(AnchorPane) loader.load("/fxml/AddProductDetails.fxml");
		BorderPane border=homeController.borderpane;
		
		border.setCenter(a);
	}
	
}
