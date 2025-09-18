import java.util.logging.*;


public class Main {
    public static void main(String[] args) {
            System.out.println("It's alive! It's alive!");
    }

    private static void configureLogging() {
        Logger logClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger logClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        logClassA.setLevel(Level.ALL);
        logClassB.setLevel(Level.WARNING);
        Logger parentLogger = Logger.getLogger("org.stepic.java");
        Handler parentHandler = new ConsoleHandler();
        parentLogger.addHandler(parentHandler);
        parentHandler.setLevel(Level.ALL);
        parentHandler.setFormatter(new XMLFormatter());
        parentLogger.setUseParentHandlers(false);
    }

}

