import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import lombok.Cleanup;
import lombok.Data;
import lombok.SneakyThrows;


public @Data class People {
    private String name;
    private double age;
    private String country;;
	
    @SneakyThrows
    private String test() {
    	@Cleanup  InputStream in = null;
    	File file = new File("");
    	try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "";
    }
}
