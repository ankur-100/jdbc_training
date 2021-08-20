package com.sonata.jobtracker;

import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sonata.jobtracker.dao.JobTrackerDao;
import com.sonata.jobtracker.dao.impl.JobTrackerDaoImpl;
import com.sonata.jobtracker.model.Task;
import com.sonata.jobtracker.model.User;

public class Main {

	public static void main(String[] args) {
		JobTrackerDao jt = new JobTrackerDaoImpl();
		/*Date c1 = new Date();
		Task task = new Task();
		task.setTaskId(7);
		task.setOwnerId(0);
		task.setName("using prepare");
		task.setDescription("examples");
		task.setStatus("HIGH");
		task.setNotes("nil");
		task.setIsBookmarked(true);
		
		String s = "01/02/1989";
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 =new Date();;
		try {
			date1 = sd.parse(s);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		User user = new User();
		user.setUserId(2);
		user.setUserName("ABC");
		user.setEmail("abc@gmail.com");
		user.setFirstName("ab");
		user.setLastName("cd");
		user.setContactNumber(2789870L);
		user.setRole("Dev");
		user.setIsAlive(true);
		
		try {
			System.out.println(jt.addTask(task));
			System.out.println(jt.addUser(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			List<Task> t = jt.getAllTasks();
			System.out.println(t.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Task> t1 = jt.getAllTasksByStatus("Active");
			System.out.println(t1.size());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			jt.assignTaskUser(7, 5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jt.updateTaskStatus(5, "Active");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			jt.updateTaskNotes(7, "adding notes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<Task> t2 = jt.getAllTasksByOwner(5);
			System.out.println(t2.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List <Task> t2 = jt.searchTask(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
