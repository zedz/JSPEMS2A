package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtils;

public abstract class BaseDAO<T> {
	public List<T> select(String sql,Object[] objs){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<T> list=new ArrayList<T>();
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement(sql);
			if(objs!=null){
				for(int i=0;i<objs.length;i++){
					pst.setObject(i+1, objs[i]);
				}
			}
			rs=pst.executeQuery();
			while(rs.next()){
				list.add(toEntity(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	public void update(String sql,Object[] objs){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtils.getConnection();
			pst=conn.prepareStatement(sql);
			if(objs!=null){
				for(int i=0;i<objs.length;i++){
					pst.setObject(i+1, objs[i]);
				}
			}
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeConnection(conn);
		}
		
	}
	public abstract T toEntity(ResultSet rs) throws Exception;
}
