package com.billdiary.ui;



///import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.billdiary.config.SpringFxmlLoader;
import com.billdiary.model.User;
import com.billdiary.service.LoginService;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


@Controller("LoginController")
public class LoginController {
	
	private SimpleStringProperty title;
	public static BorderPane root=new BorderPane();
	public static StackPane root1= new StackPane();
	public static BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}
//	final static Logger LOGGER = Logger.getLogger(LoginController.class);
	
	// Reference to the main application
    @SuppressWarnings("unused")
    private MainController mainController;
	
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@Autowired
	private LoginService loginService;
	
	
	
	@Autowired
	private User user;
	
	@FXML private Text actiontarget;
	@FXML private TextField textField;
	@FXML private PasswordField passwordField;
	
	
	
	public LoginController()
	{
		
	}
    
    @FXML protected void handleSignInButtonAction(ActionEvent event) {
    	
    //	LOGGER.debug("In method LoginController:handleSignInButtonAction Entry ");
    	
    	
    	
    	String userName=textField.getText();
    	String password=passwordField.getText();
    	System.out.println("dffsdfds");
    	if(userName!=null && password!=null)
    	{
    		System.out.println("dfdsfd");
    		user.setUserName(userName);
    		user.setPassword(password);
    		if(loginService.doLogin(user))
    		{
    			actiontarget.setText("Login Successfull");
    			//SpringFxmlLoader loader=mainController.getLoader();
    			//String m=loader.getMessage("Main.Title");
    			//title=new SimpleStringProperty(m);
    			((Node)(event.getSource())).getScene().getWindow().hide();
    			SpringFxmlLoader loader=mainController.getLoader();
    			root1= (StackPane) loader.load("/fxml/Home.fxml");
    			 Scene scene = new Scene(root1,600,400);
    			 
    		     Stage stage=new Stage();
    			 stage.setMaximized(true);
    		     stage.setTitle("BillDiary version 1.0");
    		       stage.setScene(scene);
    		        stage.show();
    		}
    		else {
    			actiontarget.setText("Login failed");
    		}
    			
    		
    	}else
    	{
    		actiontarget.setText("UserName & Password cannot be valid");
    	}
    	
    	//LOGGER.debug("In method LoginController:handleSignInButtonAction Exit ");
        
    }
 
	
    public void loadWindow(Parent root,String title)
	{
		Stage stage = new Stage();
		Scene scene = new Scene(root, 800, 600); 
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
	}
	
}
