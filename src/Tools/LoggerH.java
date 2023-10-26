package Tools;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class LoggerH {
        private static final Logger logger = Logger.getLogger("MyLog");
        public static void setupLogger() {
            FileHandler fh;
            try {
                fh = new FileHandler("MascotasLog.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void logException(Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

