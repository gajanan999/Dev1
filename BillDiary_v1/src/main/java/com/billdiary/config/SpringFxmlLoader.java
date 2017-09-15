package com.billdiary.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.util.Callback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;


@Component
public class SpringFxmlLoader {

	private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	public Object load(String url) {

		try (InputStream fxmlStream = SpringFxmlLoader.class.getResourceAsStream(url)) {
			System.err.println(SpringFxmlLoader.class.getResourceAsStream(url));
			FXMLLoader loader = new FXMLLoader();
			URL location = getClass().getResource(url);
			loader.setLocation(location);
			//loader.setResources(resources);
			loader.setControllerFactory(new Callback<Class<?>, Object>() {
				@Override
				public Object call(Class<?> clazz) {
					return applicationContext.getBean(clazz);
				}
			});
			return loader.load(fxmlStream);
		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}
	
	public static String getMessage(String key) {
		 
        try {
            MessageSource bean = applicationContext.getBean(MessageSource.class);
            
            return bean.getMessage(key, null, Locale.getDefault());
        }
        catch (Exception e) {
            return "Unresolved key: " + key;
        }
 
    }

}
