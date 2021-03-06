package net.mamoe.jpre;

import net.mamoe.jpre.network.Network;
import net.mamoe.jpre.plugin.Plugin;
import net.mamoe.jpre.plugin.PluginManager;
import net.mamoe.jpre.scheduler.Scheduler;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

/**
 * JPRE 主类
 * <p>
 * 如果你想开发插件. 请查看 {@link Plugin}
 *
 * @author Him188 @ JPRE Project
 * @see PluginManager 真正的插件管理器
 */
@SuppressWarnings("WeakerAccess")
public final class JPREMain {
    /* Instance */
    private static JPREMain instance;

    public static JPREMain getInstance() {
        return instance;
    }

    private JPREMain() {
        running = true;
        serverScheduler = new Scheduler(50, this);
        serverScheduler.start();
    }

    @Override
    public String toString() {
        return "JPREMain";
    }

    /* Server Scheduler */
    private Scheduler serverScheduler;

    /**
     * Server Scheduler
     *
     * @return Server Scheduler
     */
    public Scheduler getScheduler() {
        return serverScheduler;
    }

    /* Constants */
    public static final int DEFAULT_PORT = 420;
    public static final String VERSION_TYPE = "EAP";
    public static final String VERSION = "1.0.0";

    private boolean running;

    public boolean isRunning() {
        return running;
    }

    public void shutdown() {
        running = false;
    }

    public static void main(String... args) throws Exception {
        printAbout();

        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("h", "help", false, "Print the usage information");
        options.addOption("p", "port", true, "Set the server port number");
	    options.addOption("v", "version", true, "Show version");

        CommandLine commandLine = parser.parse(options, args);

        if (commandLine.hasOption("h")) {
            System.out.println("Help Message");
            System.exit(0);
        }

	    if (commandLine.hasOption("v")) {
		    printAbout();
		    System.exit(0);
	    }

        int port = DEFAULT_PORT;
        if (commandLine.hasOption("p")) {
            try {
                port = Integer.parseInt(commandLine.getOptionValue("p"));
            } catch (NumberFormatException ignored) {
                System.out.println("The port you set is invalid. It must be a number in 1~65535");
                System.exit(0);
            }
        }

        System.out.println("Starting server...");
        int finalPort = port;
        instance = new JPREMain();
        new Thread(() -> {
            try {
                Network.start(instance, finalPort);
            } catch (InterruptedException ignored) {
                System.out.println("Starting server failed. Could not open port " + finalPort);
	            System.exit(0);
            } catch (Throwable e) {
	            e.printStackTrace();
            }
        }).start();
        System.out.println("JPRE server is listening port " + port);

        System.out.println("Server startup done!");
    }

    /**
     * 输出关于信息
     */
    private static void printAbout() {
        System.out.println("MPQ JavaPluginRuntimeEnvironment");
        System.out.println("Version: " + VERSION_TYPE + ", v" + VERSION);
        System.out.println("Author: Him188 & LamGC & Other fiends @ MamoeTech");
        System.out.println("GitHub: https://github.com/MamoeTech/JPRE\n");
    }

    /* DataFolder */

    private static String dataFolder = System.getProperty("user.dir");

    public static String getDataFolder() {
        return dataFolder;
    }

	//for other applications, like Nukkit
	public static void setDataFolder(String dataFolder) {
		JPREMain.dataFolder = dataFolder;
	}
}
