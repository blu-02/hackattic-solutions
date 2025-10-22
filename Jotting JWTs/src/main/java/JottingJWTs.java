import com.sun.net.httpserver.HttpServer;
import util.CommonUtil;

import java.io.IOException;
import java.net.InetSocketAddress;

public class JottingJWTs {

    public static void main(String[] args) {
        CommonUtil util = new CommonUtil();

        JottingJWTsProblem problem = util.getProblem("https://hackattic.com/challenges/jotting_jwts/problem", JottingJWTsProblem.class);
        System.out.println(problem.getJwtSecret());

        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
