package ITK;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Daos.AbstractDao;
import ITK.Unit;

public class UnitDao extends AbstractDao {

	public List<Unit> getAllUnits() throws SQLException{
		List<Unit> units = new ArrayList<Unit>();
		try 
		{
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit");
			
			while (rs.next()) {
				Unit unit = new Unit();
				unit.setId(rs.getInt(1));
				unit.setName(rs.getString(2));
				unit.setCode(rs.getString(3));
				units.add(unit);
			}
		} 
		finally
		{
			closeResources();
		}
		return units;
	}

	public void addUnit(String name,String code) throws SQLException{
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(String.format("INSERT INTO unit VALUES(NEXT VALUE FOR seq1,'%s','%s');",name,code));
		} finally {
			closeResources();
		}
	}
	
	public List<Unit> searchUnits(String partialName) throws SQLException{
		partialName = "%"+partialName+"%";
		partialName = partialName.toUpperCase();
		List<Unit> units = new ArrayList<Unit>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(String.format("SELECT * FROM unit WHERE UPPER(name) LIKE '%s'",partialName));
			
			while (rs.next()) {
				Unit unit = new Unit();
				unit.setId(rs.getInt(1));
				unit.setName(rs.getString(2));
				unit.setCode(rs.getString(3));
				units.add(unit);
			}
		} finally {
			closeResources();
		}
		return units;
	}
	
	public void removeUnit(Integer unitId) throws SQLException{
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(String.format("DELETE FROM unit WHERE id=%s",unitId));
		} finally {
			closeResources();
		}
	}
	
	public void removeAllEntries() throws SQLException{
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("TRUNCATE TABLE unit");
		} finally {
			closeResources();
		}
	}
	
}