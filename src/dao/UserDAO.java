package dao;

import java.sql.ResultSet;
import java.util.List;

import entity.User;

public class UserDAO extends BaseDAO<User>{
	public List<User> findall(){
		String sql="select * from user_zzj";
		List<User> list=select(sql, null);
		return list;
	}
	
	public void save(User user){
		String save="insert into user_zzj values(?,?,?,?)";
		update(save, new Object[]{user.getUsername(),user.getPwd(),user.getRealName(),user.getGender()});
		
	}
	
	public User findByUsername(String username){
		String sql="select * from user_zzj where username=?";
		List<User> list=select(sql, new Object[]{username});
		if(list.size()!=0){
			User user=list.get(0);
			return user;
		}
		return null;	
	}

	@Override
	public User toEntity(ResultSet rs) throws Exception {
		User user=new User(rs.getString("username"), rs.getString("pwd"), rs.getString("realname"), rs.getString("gender"));
		user.setAuth(rs.getString("auth"));
		return user;
	}



}
