package pmqin.com.test;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class Optionstest {

	public static void main(String[] args) {
		//-t mysql -h 10.32.7.5 -P 3306 -u root -p root -e "use datax_test;select * from csy_test_hive_ms limit 10;use adhocdb;select * from user_info;"
		int exitCode = 0;
		CommandLineParser parser = new DefaultParser();

		Options options = new Options();
		options.addOption("t", "type", true, "database type[sqlserver|mysql]");
		options.addOption("h", "host", true, "database hostname");
		options.addOption("P", "port", true, "database port");

		options.addOption("e", "execute-sql", true, "execute sql");
		options.addOption("f", "file", true, "execute file");
		if (args == null || args.length == 0) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("Optionstest", options);
			exitCode = 3;
		}
		try {

			CommandLine line = parser.parse(options, args);
			String type = null, host = null, port = null, sql = null;
			type = line.getOptionValue("t");

			host = line.getOptionValue("h");
			port = line.getOptionValue("P");
			if (!line.hasOption("e") && !line.hasOption("f")) {
				if (line.getArgs().length >= 1) {
					sql = line.getArgs()[0];
				}
			} else {
				sql = line.getOptionValue("e");
			}
			System.out.println(type+host+port);

		} catch (Exception e) {
			e.printStackTrace();
			exitCode = 2;
		}
		
		System.exit(exitCode);
		
	}

}
