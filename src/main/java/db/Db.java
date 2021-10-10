package db;

import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.ScriptResolver.classPathScript;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static com.wix.mysql.distribution.Version.v5_6_23;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.MysqldConfig;

public class Db {
	EmbeddedMysql mysqld;


	public void dbStart() throws SQLException {
		Date date = new Date(Long.parseLong("1633536401447"));
		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss:mm z");
		System.out.println(formatter.format(date));
		
		
		MysqldConfig config = aMysqldConfig(v5_6_23)
				  .withPort(3307)
				  .withUser("rt", "")
				  .build();

				mysqld = anEmbeddedMysql(config)
//				  .addSchema("gitbucket")
				  .addSchema("aschema", classPathScript("db/001_init.sql"))
				  .start();

//				Connection conn = DriverManager.getConnection(
//				  "jdbc:mysql://localhost:3306/gitbucket", "rob", "");
	}
	
	public void dbStop() {
		mysqld.stop();
		System.out.println("Stop");
	}
}
