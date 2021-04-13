package com.zhangjunqiao.zchz.qqzonegetpics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author 张俊俏
 * Web Crawler Demo仿造网上的一个例子写的抓取qq空间头像的网络爬虫java+maven程序，还没有实现的是让这个程序一直跑着，一直下载着头像，多线程，线程池这块还不太熟
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
