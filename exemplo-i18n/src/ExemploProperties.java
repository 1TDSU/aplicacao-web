import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExemploProperties {

	
	public static Properties getProp() throws IOException{
		
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("./properties/dados.properties");
		
		prop.load(fs);
		return prop;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		String host  = null;
		String pass  = null;
		String login = null;
		
		Properties prop = getProp();
		host  = prop.getProperty("prop.server.host");
		pass  = prop.getProperty("prop.server.password");
		login = prop.getProperty("prop.server.login");
		
		System.out.println("HOST     : " + host);
		System.out.println("Password : " + pass);
		System.out.println("Login    : " + login);
		
	}

}
