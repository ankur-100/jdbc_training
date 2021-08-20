package com.sonata.jobtracker.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sonata.jobtracker.dao.MyConnection;
import com.sonata.jobtracker.model.Task;
import com.sonata.jobtracker.model.User;

public class JobTrackerDaoImpl implements com.sonata.jobtracker.dao.JobTrackerDao {
	@Override
	public boolean addTask(Task task) throws SQLException{
		boolean added = false;
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String sql = "INSERT INTO Task VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pst =  conn.prepareStatement(sql);
		pst.setInt(1, task.getTaskId());
		pst.setInt(2, task.getOwnerId());
		pst.setString(3, task.getName());
		pst.setString(4, task.getDescription());
		pst.setString(5, task.getStatus());
		pst.setString(6, task.getPriority());
		pst.setString(7, task.getNotes());
		pst.setBoolean(8, task.getIsBookmarked());
		pst.setDate(9, task.getCreatedOn());
		pst.setDate(10, task.getStatusChangedOn());
		int r = pst.executeUpdate();
		pst.close();
		conn.close();
		if (r > 0)
			added = true;
		return added;
	}

	@Override
	public boolean addUser(User user) throws SQLException {
		boolean added = false;
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String sql1 = "INSERT INTO Users VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement qst =  conn.prepareStatement(sql1);
		qst.setInt(1, user.getUserId());
		qst.setString(2, user.getUserName());
		qst.setString(3, user.getEmail());
		qst.setString(4, user.getFirstName());
		qst.setString(5, user.getLastName());
		qst.setLong(6, user.getContactNumber());
		qst.setString(7, user.getRole());
		qst.setBoolean(8, user.getIsAlive());
		qst.setDate(9, (Date) user.getDob());
		qst.setDate(10, (Date) user.getCreatedOn());
		
		int r = qst.executeUpdate();
		qst.close();
		conn.close();
		if (r > 0)
			added = true;
		return added;
	}

	@Override
	public List<Task> getAllTasks() throws SQLException {
		// TODO Auto-generated method stub
		List<Task> tasklist = new ArrayList<Task>();
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String sql ="SELECT * from Task";
		PreparedStatement qst =  conn.prepareStatement(sql);
		ResultSet rs = qst.executeQuery();
		
		while(rs.next()) {
			Task task = new Task();
			task.setTaskId(rs.getInt("taskId"));
			task.setOwnerId(rs.getInt("ownerId"));
			task.setName(rs.getString("name"));
			tasklist.add(task);
		}
		rs.close();
		qst.close();
		conn.close();
		return tasklist;
	}

	@Override
	public List<Task> getAllTasksByStatus(String status) throws SQLException {
		List<Task> taskbystatus = new ArrayList<Task>();
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String sql ="SELECT * from Task WHERE status LIKE " +"'"+ status + "'";
		PreparedStatement qst =  conn.prepareStatement(sql);
		ResultSet rs = qst.executeQuery();
		
		while(rs.next()) {
			Task task = new Task();
			task.setTaskId(rs.getInt("taskId"));
			task.setOwnerId(rs.getInt("ownerId"));
			task.setName(rs.getString("name"));
			taskbystatus.add(task);
		}
		rs.close();
		qst.close();
		conn.close();
		return taskbystatus;
	}

	@Override
	public List<Task> getAllTasksByOwner(int ownerId) throws SQLException {
		List<Task> taskbyownerid = new ArrayList<Task>();
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String sql ="SELECT * from Task WHERE ownerId = " +ownerId;
		PreparedStatement qst =  conn.prepareStatement(sql);
		ResultSet rs = qst.executeQuery();
		
		while(rs.next()) {
			Task task = new Task();
			task.setTaskId(rs.getInt("taskId"));
			task.setOwnerId(rs.getInt("ownerId"));
			task.setName(rs.getString("name"));
			taskbyownerid.add(task);
		}
		rs.close();
		qst.close();
		conn.close();
		return taskbyownerid;
	}
	@Override
	public int updateTaskStatus(int taskId, String status) throws SQLException{
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET status = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setString(1, status);
		qst.setInt(2, taskId);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return taskId;
	}

	@Override
	public int assignTaskUser(int taskId, int ownerId) throws SQLException{
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET ownerId = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setInt(1, ownerId);
		qst.setInt(2, taskId);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return ownerId;
	}

	@Override
	public int updateTaskPriority(int taskid, String priority) throws SQLException{
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET priority = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setString(1, priority);
		qst.setInt(2, taskid);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return taskid;
	}

	@Override
	public int updateTaskNotes(int taskid, String notes) throws SQLException{
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET notes = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setString(1, notes);
		qst.setInt(2, taskid);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return taskid;
	}

	@Override
	public int updateTaskBookmark(int taskid, String bookmark) throws SQLException{
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "UPDATE task SET isBookmarked = ? WHERE taskId = ?";
		PreparedStatement qst =  conn.prepareStatement(query);
		qst.setString(1, bookmark);
		qst.setInt(2, taskid);
		qst.executeUpdate();
		qst.close();
		conn.close();
		return taskid;
		
	}

	@Override
	public List<Task> searchTask(int taskId) throws SQLException{
		List<Task> tasksearch = new ArrayList<Task>();
		Connection conn = new MyConnectionImpl().connectToMySQL();
		System.out.println(conn);
		String query = "SELECT * FROM task WHERE taskId = " + taskId;
		PreparedStatement qst =  conn.prepareStatement(query);
		ResultSet rs = qst.executeQuery();
		while(rs.next()) {
			Task task = new Task();
			task.setTaskId(rs.getInt("taskId"));
			task.setOwnerId(rs.getInt("ownerId"));
			task.setName(rs.getString("name"));
			tasksearch.add(task);
			System.out.println(taskId + " " + "Task Name:" + task.getName());
		}
		rs.close();
		qst.close();
		conn.close();
		return tasksearch;
		
	}

}
