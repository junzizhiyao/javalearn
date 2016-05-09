package me.yangyao.javalearn.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节数组样例程序
 * @author yangyao
 *
 */
public class ByteArrayExample {

	
	public static void main(String[] args) throws IOException {
		//写入字节数据
		OutputStream outputStream = new ByteArrayOutputStream();
		
		outputStream.write( "ByteArrayEaxmple class".getBytes("UTF-8") );
		
		//省略关闭流...
		
		//读取字节数组
		byte[] bytes = ((ByteArrayOutputStream)outputStream).toByteArray();
		
		InputStream inputStream = new ByteArrayInputStream(bytes);
		
		int data = inputStream.read();
		
		while( data != -1 ){
			System.out.print( (char)data );
			data = inputStream.read();
		}
		
		//省略关闭流...
		
	}
	
}
