package com.zhangjunqiao.zchz.qqzonegetpics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author 张俊俏
 *
 */
 
public class App 
{
	public static final ScheduledExecutorService service = Executors
			.newScheduledThreadPool(3);
	
    public static void main( String[] args )
    {
    	FindPicThread target = new FindPicThread();

		List<Thread> proxy = new ArrayList<Thread>();
		for (int i = 0; i < 10000; i++) {
			System.out.println("Create thread "+ i);
			proxy.add(new Thread(target, "Thread-" + i));
		}

		for (Thread thread1 : proxy) {
			service.execute(thread1 ); 
		}
 
        System.out.println( "Finished !" );
    }
}
