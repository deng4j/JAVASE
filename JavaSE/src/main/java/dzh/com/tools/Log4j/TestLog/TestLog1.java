package dzh.com.tools.Log4j.TestLog;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * \log4j.properties
 */
public class TestLog1 {

    private static final Logger LOGGER=LoggerFactory.getLogger(TestLog1.class);

    public static void main(String[] args) {
       // LOGGER.debug("debug级别日志");
        LOGGER.info("info级别日志");
//        LOGGER.warn("warn级别日志");
//        LOGGER.error("error级别日志");
    }
}
