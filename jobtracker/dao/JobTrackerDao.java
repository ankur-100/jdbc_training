package com.sonata.jobtracker.dao;

import java.sql.SQLException;
import java.util.List;

import com.sonata.jobtracker.model.Task;
import com.sonata.jobtracker.model.User;

public interface JobTrackerDao {
	public boolean addTask(Task task) throws SQLException;
	public boolean addUser(User user) throws SQLException;
	public List<Task> getAllTasks() throws SQLException;
	public List<Task> getAllTasksByStatus(String status) throws SQLException;
	public List<Task> getAllTasksByOwner(int ownerId) throws SQLException;
	public int updateTaskStatus(int taskId, String status) throws SQLException;
	public int assignTaskUser(int taskId, int ownerId) throws SQLException;
	public int updateTaskPriority(int taskid, String priority) throws SQLException;
	public int updateTaskNotes(int taskid, String notes) throws SQLException;
	public int updateTaskBookmark(int taskid, String bookmark) throws SQLException;
	public List<Task> searchTask(int taskId) throws SQLException;
	

}
