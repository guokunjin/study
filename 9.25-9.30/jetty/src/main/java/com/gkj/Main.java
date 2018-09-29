package com.gkj;


import com.gkj.servlet.TestServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Server server = new Server(80);
        WebAppContext context=new WebAppContext();
        context.setWar("D:\\gitRespositories\\study\\9.25-9.30\\webDemo\\target\\webDemo.war");
        context.setContextPath("/");
        server.setHandler(context);
//
//            ServletContextHandler context = new ServletContextHandler(
//                    ServletContextHandler.SESSIONS);
//            context.setContextPath("/");
//            server.setHandler(context);
//
//            context.addServlet(new ServletHolder(new TestServlet()),
//                "/test");
        LOGGER.info("server start.");
        server.start();
        server.join();

    }
}
