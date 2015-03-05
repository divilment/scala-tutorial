import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.HttpConnection;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.handler.AbstractHandler;

public class HelloWorld{

    public static void main(String[] args){

        int timeout = Integer.parseInt(args[0]);

        try {
            URL url = new URL("http://localhost:8090/");
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(1000); // 1s timeout to connect
            conn.setReadTimeout(timeout); // 5s max time between data being available?
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String result = null;
            while((result = in.readLine()) != null){
                System.out.println(result);
                Thread.sleep(10000);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
