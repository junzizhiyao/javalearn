/**
 * 
 */
package me.yangyao.javalearn.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符数组样例程序
 * @author yangyao
 *
 */
public class CharArrayExample {

	public static void main(String[] args) throws IOException {
		Writer writer = new CharArrayWriter();
		writer.write( "CharArrayExample class" );
		
		//省略关闭流...
		
		char[] chars =  ( (CharArrayWriter)writer ).toCharArray();
		
		Reader reader = new CharArrayReader(chars);
		
		int data = reader.read();
		
		while( data != -1 ){
			System.out.print( (char)data );
			data = reader.read();
		}
		
		//省略关闭流...
		
	}
	
}
