package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;


public class EmpDAO extends BaseDAO<Emp>{
	public void save(Emp e){
		String insert="insert into emp_servlet_zzj values (emp_s_id_zzj.nextval,?,?,?)";
		update(insert, new Object[]{e.getName(),e.getSalary(),e.getAge()});
	}
	
	public void del(int id){
		String delete="delete from emp_servlet_zzj where id=?";
		update(delete, new Object[]{id});
	}
	
	public Emp findById(int id){
		String findbyid="select * from emp_servlet_zzj where id=?";
		List<Emp> list=select(findbyid, new Object[]{id});
		return list.get(0);
	}
	
	public void modify(Emp e){
		String modify="update emp_servlet_zzj set name=?,salary=?,age=? where id=?";
		update(modify, new Object[]{e.getName(),e.getSalary(),e.getAge(),e.getId()});
	}
	
	public List<Emp> findAll(){
		String findall="select * from emp_servlet_zzj";
		List<Emp> list=new ArrayList<Emp>();
		list=select(findall, null);
		return list;
	}

	@Override
	public Emp toEntity(ResultSet rs) throws Exception {
		return new Emp(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"), rs.getInt("age"));
	}

}
