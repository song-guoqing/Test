import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ModifyFileDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Please input folder, eg: D:/test ");
		Scanner str = new Scanner(System.in);
		String directory = str.next().trim();
		System.out.println("Please input date to change, eg: 2016-04-28 ");
		
		Scanner dateIn = new Scanner(System.in);
		String dateStr = dateIn.next().trim();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date todate = null;
		try {
			todate = format.parse(dateStr);
		} catch(Exception e) {
			System.out.println("illegal date!");
		}
		
		File dir = new File(directory);
		if(!dir.exists()) {
			System.out.println(directory + " is not exist!");
		} else if(!dir.isDirectory()) {
			System.out.println(directory + " is not a folder!");
		} else {
				File[] files = dir.listFiles();
				for(File file:files) {
					file.setLastModified(todate.getTime());
				}
		}
		
	}

}
