package seleniumtopics1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaptureHashMap {
	Properties prop;
	File file;

	@BeforeMethod
	public void setUp() throws IOException {
		file = new File(System.getProperty("user.dir") + File.separator + "capture.properties");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
	}

	@Test
	public void test1() throws FileNotFoundException, IOException {
		
		System.out.println("1" + "\n" + "2");
		LinkedHashMap<String, String> maps = new LinkedHashMap<>();
		maps.put("1", "A");
		maps.put("2", "B");
		maps.put("3", "C");
		maps.put("4", "D");
		for (Map.Entry<String, String> entry : maps.entrySet()) {
			prop.setProperty(entry.getKey(), entry.getValue());
		}

	}

	@Test
	public void test2() {

	}

	@AfterMethod
	public void tearDown() throws FileNotFoundException, IOException {
		prop.store(new FileOutputStream(file), null);
		System.out.println("done");
	}
}

/*
 * Set<Entry<Object, Object>> entries = props.entrySet(); for (Entry<Object,
 * Object> entry : entries) { System.out.println(entry.getKey() + " : " +
 * entry.getValue()); }
 */

/*
 * public static void resetAndWriteCaptureData() throws IOException {
 * 
 * File newFile = new File(FCIPConstants.FCIP_REPO + File.separator +
 * "capture.properties"); if(newFile.exists()) { newFile.delete(); } File file =
 * new File(FCIPConstants.FCIP_REPO);
 * 
 * file.mkdirs(); newFile.createNewFile(); try { Properties properties = new
 * Properties();
 * 
 * for (Map.Entry<String, String> entry : capturedData.entrySet()) {
 * properties.put(entry.getKey(), entry.getValue()); }
 * 
 * properties.store(new FileOutputStream(newFile), null);
 * 
 * } catch (Exception e) { }
 * 
 * }
 */
