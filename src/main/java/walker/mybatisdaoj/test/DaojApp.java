package walker.mybatisdaoj.test;

import walker.mybatis.daoj.core.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DaojApp {

    private static Logger log = LoggerFactory.getLogger(DaojApp.class);

    public static void main(String[] args) {
        try {
            new Generator("mybatis-daoj.xml").generateCode();
            new Generator("mybatis-daoj.xml").generateDoc();

        } catch (Exception e) {
            log.error("", e);
        }
    }
}
