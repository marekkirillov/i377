package dao;

import java.io.File;

import org.apache.tools.ant.taskdefs.SQLExec;

import util.AntUtil;


public class SetupDao{

	public void createSchema() {
        String filePath = getClass().getResource("/DatabaseSchema.sql").getFile();

        executeSql(filePath);
    }
	
	public void addSampleData(){
        String filePath = getClass().getResource("/DatabaseData.sql").getFile();

        executeSql(filePath);
	}

    private void executeSql(String filePath) {
        SQLExec sql = AntUtil.getTask(SQLExec.class, "sql");
        sql.setSrc(new File(filePath));
        sql.setDriver("org.hsqldb.jdbcDriver");
        sql.setUserid("sa");
        sql.setPassword("");
        sql.setUrl("jdbc:hsqldb:file:C:/Users/Marek/data/localDB;shutdown=true");
        sql.execute();
    }
}