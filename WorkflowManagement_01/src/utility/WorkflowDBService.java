package utility;

import java.sql.*;
import java.util.ArrayList;

import model.WorkflowMaster;

public class WorkflowDBService {

	public static int insertObjectInDB(String workflow_table,
			ArrayList<String> params) {
		int result;
		Connection conn = null;
		PreparedStatement pst = null;
		String insertQuery = "INSERT INTO `" + workflow_table + "`"
				+ " ( `stage_name`, `stage_description`, `stage_sla`,"
				+ " `stage_seqno`, `stage_lead_id`, `w_id`) VALUES (?,"
				+ "?,?,?,?,?)";
		int i = 1;

		try {
			conn = new MySqlConnection().getConnection();
			pst = conn.prepareStatement(insertQuery);

			for (String string : params) {
				if (i < 3)
					pst.setString(i, string);
				else
					pst.setInt(i, Integer.parseInt(string));
				i++;
			}

			result = pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public static int createTables(String workflow_table, String stage_table,
			String item_table, String lead_bucket, String general_bucket) {
		String workflowCreateTableQuery = "CREATE TABLE IF NOT EXISTS `"
				+ workflow_table
				+ "` ("
				+ "  `stage_id` int(5) NOT NULL AUTO_INCREMENT,"
				+ "`stage_name` varchar(30) COLLATE utf8_bin NOT NULL,"
				+ "`stage_description` varchar(100) COLLATE utf8_bin NOT NULL,"
				+ "`stage_sla` int(5) NOT NULL COMMENT 'values should be in hours',"
				+ "`stage_seqno` int(5) NOT NULL,"
				+ "`stage_lead_id` int(5) NOT NULL,"
				+ "`w_id` int(5) NOT NULL,"
				+ "PRIMARY KEY (`stage_id`),"
				+ "KEY `stage_lead_id` (`stage_lead_id`),"
				+ "KEY `w_id` (`w_id`)"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1";

		String workflowConstraintsQuery = "ALTER TABLE `"
				+ workflow_table
				+ "` ADD CONSTRAINT `"
				+ workflow_table
				+ "_ibfk_1` FOREIGN KEY (`stage_lead_id`) REFERENCES "
				+ "`personal_information` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE,  "
				+ "ADD CONSTRAINT `" + workflow_table
				+ "_ibfk_2` FOREIGN KEY (`w_id`) REFERENCES `workflow_master`"
				+ " (`w_id`) ON DELETE CASCADE ON UPDATE CASCADE";

		String stageCreateTableQuery = "CREATE TABLE IF NOT EXISTS `"
				+ stage_table + "`(`stage_id` int(5) NOT NULL,"
				+ "`p_id` int(5) NOT NULL,"
				+ "`status` set('A','I') COLLATE utf8_bin NOT NULL,"
				+ "PRIMARY KEY (`p_id`,`stage_id`),"
				+ "KEY `stage_id` (`stage_id`,`p_id`)"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin";

		String stageConstraintsQuery = "ALTER TABLE `"
				+ stage_table
				+ " ADD CONSTRAINT `"
				+ stage_table
				+ "_ibfk_1` FOREIGN KEY (`stage_id`) REFERENCES "
				+ workflow_table
				+ " (`stage_id`) ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "ADD CONSTRAINT `"
				+ stage_table
				+ "_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `personal_information` (`p_id`) "
				+ "ON DELETE CASCADE ON UPDATE CASCADE";

		String itemCreateTableQuery = "CREATE TABLE IF NOT EXISTS `"
				+ item_table
				+ "` ( `item_id` int(5) NOT NULL AUTO_INCREMENT,"
				+ "`item_name` varchar(30) COLLATE utf8_bin NOT NULL,"
				+ " `item_description` varchar(100) COLLATE utf8_bin NOT NULL,"
				+ " `current_stage_id` int(5) NOT NULL,"
				+ " `remarks` longtext COLLATE utf8_bin NOT NULL,"
				+ " `file_path` varchar(500) COLLATE utf8_bin NOT NULL, "
				+ "PRIMARY KEY (`item_id`), KEY `current_stage_id` (`current_stage_id`))"
				+ " ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ";

		String itemConstraintsQuery = "ALTER TABLE `" + item_table
				+ "` ADD CONSTRAINT `" + item_table
				+ "_ibfk_1` FOREIGN KEY (`current_stage_id`) REFERENCES `"
				+ workflow_table
				+ "` (`stage_id`) ON DELETE CASCADE ON UPDATE CASCADE";

		try {
			DDLQueryInDB(workflowCreateTableQuery);
			DDLQueryInDB(workflowConstraintsQuery);
			System.out.println("workflow created");
			DDLQueryInDB(stageCreateTableQuery);
			DDLQueryInDB(stageConstraintsQuery);
			System.out.println("Stage created");
			DDLQueryInDB(itemCreateTableQuery);
			DDLQueryInDB(itemConstraintsQuery);
			System.out.println("item created");

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int DDLQueryInDB(String sqlQuery) {
		int result;
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = new MySqlConnection().getConnection();
			pst = conn.prepareStatement(sqlQuery);
			result = pst.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

}
