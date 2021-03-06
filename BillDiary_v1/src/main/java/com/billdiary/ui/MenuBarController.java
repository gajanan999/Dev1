package com.billdiary.ui;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.billdiary.config.SpringFxmlLoader;
import com.billdiary.model.Product;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@Controller("MenuBarController")
public class MenuBarController {
	//ResourceBundle bundle = ResourceBundle.getBundle("resources.UIResources");
	@Autowired
	public LoginController loginController;
	 public MenuBarController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML private void addShopDetails()
	{
		
		SpringFxmlLoader loader=MainController.getLoader();
		//ResourceBundle bundle = ResourceBundle.getBundle("resources.UIResources");
		
		
		AnchorPane addShop=(AnchorPane) loader.load("/fxml/AddShopDetails.fxml");
		
		BorderPane root = new BorderPane();
		 root.setCenter(addShop);
		 
		Scene scene = new Scene(root,800,600);
			     Stage stage=new Stage();
		 //stage.setMaximized(true);
	     stage.setTitle("Add Shop Details");
	     stage.setMinHeight(600);
	     stage.setMinWidth(800);
	       stage.setScene(scene);
	        stage.show();
	        
	}
	@FXML private void addProductDetails()
	{
		
		SpringFxmlLoader loader=MainController.getLoader();
		AnchorPane addProduct=(AnchorPane) loader.load("/fxml/AddProductDetails.fxml");
		

		BorderPane root = new BorderPane();
		 root.setCenter(addProduct);
		 loginController.loadWindow(root,"Add Product Details");
		/*Scene scene = new Scene(root,800,600);
			     Stage stage=new Stage();
		 //stage.setMaximized(true);
	     stage.setTitle("Add Product Details");
	     stage.setMinHeight(600);
	     stage.setMinWidth(800);
	       stage.setScene(scene);
	        stage.show();*/
	        
		 
	}
	@FXML private void Openpage2()
	{
		/*
		SpringFxmlLoader loader=MainController.getLoader();
		GridPane a=(GridPane) loader.load("/fxml/page1.fxml",bundle);
		BorderPane border=LoginController.getRoot();
		border.setCenter(a);
		*/
		 
	}
	@FXML
	public void initialize() {
		// TODO Auto-generated method stub
		/*
		
		id.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
		
		name.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
		price.setCellValueFactory(new PropertyValueFactory<Product,Float>("price"));
		//balance.setCellValueFactory(new PropertyValueFactory<BillInfo,Float>("balance"));
		tbid.setItems(data);
		*/
	}

}
