package com.song.jian2fan;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.spreada.utils.chinese.ZHConverter;

public class Jian2Fan {
	/** 
     * ����ת���� 
     *  
     * @param simpStr 
     *            �����ַ��� 
     * @return �����ַ��� 
     */  
    public static String SimToTra(String simpStr) {  
        ZHConverter converter = ZHConverter  
                .getInstance(ZHConverter.TRADITIONAL);  
        String traditionalStr = converter.convert(simpStr);  
        return traditionalStr;  
    }  
  
    /** 
     * ����ת���� 
     *  
     * @param tradStr 
     *            �����ַ��� 
     * @return �����ַ��� 
     */  
    public static String TraToSim(String tradStr) {  
        ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);  
        String simplifiedStr = converter.convert(tradStr);  
//System.out.println(simplifiedStr);
        return simplifiedStr;  
    }  
	
	/**
	 * ת��һ���ļ������������ļ�Ϊ��������
	 * @param folder
	 */
	public static void traAllFileToSim(String folder) {
		File file = new File(folder);
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(int i = 0; i < files.length; i++) {
				String filename = files[i].getName();
				if(files[i].isDirectory()) {
					traAllFileToSim(file.getAbsolutePath() + "/" + files[i].getName());
				} else if(filename.contains("jsp")||filename.contains("java")||filename.contains("js")){
					BufferedReader br = null;
					BufferedWriter bw = null;
					OutputStreamWriter out = null;
					try {
						StringBuffer buffer = new StringBuffer();
						String line = null;
						InputStreamReader reader = new InputStreamReader(new FileInputStream(files[i]),"UTF-8");
						br = new BufferedReader(reader);
						line = br.readLine();
						while(line != null) {
							buffer.append(TraToSim(line) + "\n");
//							bw.write(TraToSim(line) + "\n");
							line = br.readLine();
						}
						out = new OutputStreamWriter(new FileOutputStream(files[i]));
						bw = new BufferedWriter(out);
						bw.write(buffer.toString());
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							bw.flush();
							bw.close();
							out.close();
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		traAllFileToSim("E:\\simTest\\iclock");
//		System.out.println(TraToSim("�ι����·��c"));
	}
}
