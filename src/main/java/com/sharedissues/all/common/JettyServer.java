package com.sharedissues.all.common;

import javax.management.RuntimeErrorException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

	public static void main(String[] args) {
		if(args.length<2){
			throw new RuntimeException("Could not start jetty server.Arguments must be more than 2");
		}
		String mode= args[0];
		int port = Integer.parseInt(args[1]);
		long startTime = System.currentTimeMillis();
		System.out.println("Starting Jetty server");
		Server server =new Server(port);
		WebAppContext context =new WebAppContext();
		if(mode.equalsIgnoreCase("dev")){
			context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
			context.setResourceBase("src/main/webapp");
			context.setExtraClasspath("src/main/resources");
		}else if(mode.equalsIgnoreCase("prod")){
			context.setDescriptor("target/shared-issues-1/WEB-INF/web.xml");
        	context.setResourceBase("target/shared-issues-1");
		}
    	context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        
       try{
    	 System.out.println("Invoking .start method");
        server.start();
        long time = System.currentTimeMillis()-startTime;
        System.out.println("Jetty server started in" + time+"Milisecond or"+ time/1000+"Second");
        
       }catch(Exception e){
    	   System.out.println("Problem starting jetty server"+e.getLocalizedMessage());
       }
	}

}
