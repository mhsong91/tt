package tt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import tt.exam.Test;

public class Exam {

	public static void main(String[] args) {
		
		try {
			InputStream is = Exam.class.getResourceAsStream("class.proerties");
			Properties prop = new Properties();
			prop.load(is);
			Iterator<Object> it = prop.keySet().iterator();
			while(it.hasNext()) {
				String key = (String) it.next();
				String cn = prop.getProperty(key);
				Class c = Class.forName(cn);
				Object o = c.newInstance();
				Test t = (Test)o;
				System.out.println(t.getStr());
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException e) {
			e.printStackTrace();
		}
	}
}
