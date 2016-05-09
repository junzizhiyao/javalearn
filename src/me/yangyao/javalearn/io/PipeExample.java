/**
 * 
 */
package me.yangyao.javalearn.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <h5>管道示例程序</h5>
 * <ul>
 * 		<li>
 * 			<strong>请记得，当使用两个相关联的管道流时，务必将它们分配给不同的线程。read()方法和write()方法调用时会导致流阻塞，这意味着如果你尝试在一个线程中同时进行读和写，可能会导致线程死锁。</strong>
 * 		</li>
 * 		<li>
 * 			<strong>除了管道之外，一个JVM中不同线程之间还有许多通信的方式。实际上，线程在大多数情况下会传递完整的对象信息而非原始的字节数据。但是，如果你需要在线程之间传递字节数据，Java IO的管道是一个不错的选择。</strong>
 * 		</li>
 * </ul>
 * @author yangyao
 *
 */
public class PipeExample {

	public static void main(String[] args) throws IOException {
		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream( output );
		/*
		同以上一样的用法
		final PipedInputStream input = new PipedInputStream( );
		input.connect( output );
		output.connect( input );
		*/
		
		
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				try{
					output.write("Hello word, pipe!".getBytes());
				}catch(IOException e){
				}finally {
					if( output != null ){
						try {
							output.close();
						} catch (IOException e) {
						}
					}
				}
				
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try{
					int data = input.read();
					while( data != -1 ){
						System.out.print( (char)data );
						data = input.read();
					}
				}catch(IOException e){
				}finally{
					if( input != null ){
						try {
							input.close();
						} catch (IOException e) {
						}
					}
				}
				
			}
		});
		
		thread1.start();
		thread2.start();
		
	}
	
}
