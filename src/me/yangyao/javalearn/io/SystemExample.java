/**
 * 
 */
package me.yangyao.javalearn.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * System.in System.out System.err 学习
 * @author yangyao
 *
 */
public class SystemExample {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.in;
		
		
		
		byte[] bytes = new byte[1024];
		int len = inputStream.read(bytes);
		StringBuffer stringBuffer = new StringBuffer();
		while( len != -1 ){
			len = inputStream.read(bytes);
			stringBuffer.append( String.valueOf( bytes.toString() ) );
		}
		System.out.println( stringBuffer.toString() );
	}
	
}
