package service.impl;


import dto.TaskDetailDto;
import dto.TaskDto;
import entities.Sprint;
import entities.Task;
import entities.TaskActivity;
import util.CommonConstant;
import util.TaskStatus;
import util.Util;

import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

	private static TaskService instance = null;

	private HashMap<Long, Task> taskMap = new HashMap<>();
	private HashMap<Long, List<TaskActivity>> taskActivityMap = new HashMap<>();

	public static TaskService getInstance()
	{
		if(instance==null)
			instance=new TaskService();
		return  instance;
	}

	public TaskDto newTask(Long id ,String title,String description,Long sprintId, Long dueDate,String taskStatus,String issueType
	,Long createdBy,Long assigneeId)
	{
		TaskDto dto = new TaskDto(id,title,description,sprintId,dueDate,taskStatus,issueType,createdBy,assigneeId);
		return dto;
	}

	public Map<TaskStatus, List<Task>> getDashboard(Long sprintId) {
		System.out.println("getDashboard called for sprintId Id: "+ sprintId);
		Util.validateLong(sprintId, "Sprint Id can't be null/empty");
		Long ct = System.currentTimeMillis();
		List<Task> allTask = new ArrayList<Task>();
		Iterator taskMapIterator = taskMap.entrySet().iterator();

		while (taskMapIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)taskMapIterator.next();
			Task t = (Task) mapElement.getValue();
			System.out.println("==="+t.getSprint());
			if(t.getSprint().getId().equals(sprintId))
				allTask.add(t);
		}

		Map<TaskStatus, List<Task>> collect = allTask.stream().collect(Collectors.groupingBy(i->i.getCurrentStatus()));
		return collect;
	}

	public TaskDetailDto getTaskDetail(Long taskId) {
		System.out.println("getTaskDetail called for task Id: "+ taskId);
		Util.validateLong(taskId, "Task Id can't be null/empty");
		Task tt = taskMap.get(taskId);
		Util.noRecordFound(tt);
		List<TaskActivity> l = taskActivityMap.get(taskId);
		TaskDetailDto tdd = TaskDetailDto.tranformForDetail(tt, l);
		return tdd;
	}

	public List<Task> getDelayTask(Long sprintId) {
		System.out.println("getDelayTask called for sprintId Id: "+sprintId);
		Util.validateLong(sprintId, "Sprint Id can't be null/empty");
		Long ct = System.currentTimeMillis();
		List<Task> delaytask = new ArrayList<Task>();

		Iterator taskMapIterator = taskMap.entrySet().iterator();

		while (taskMapIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)taskMapIterator.next();
			Task t = (Task) mapElement.getValue();
			if(t.getDueDate()<ct && t.getActive()==Boolean.TRUE)
				delaytask.add(t);
		}

		return Util.noRecordFoundForList(delaytask);
	}


	public List<Task> getAssignTask(Long userId) {
		System.out.println("getAssignTask called for User Id: "+userId);
		Util.validateLong(userId, "Assign Id can't be null/empty");
		List<Task> assignTask = new ArrayList<Task>();

		Iterator taskMapIterator = taskMap.entrySet().iterator();

		while (taskMapIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)taskMapIterator.next();
			Task t = (Task) mapElement.getValue();
			if(t.getAssigneeId()==userId && t.getActive()==Boolean.TRUE)
				assignTask.add(t);
		}

		return Util.noRecordFoundForList(assignTask);
	}


	public Task createTask(TaskDto taskdto, Sprint sprint) {
		System.out.println("createTask called");
		taskdto.validateForCreate();
		Long ct = System.currentTimeMillis();
		Long userId = CommonConstant.UserId;
		Task task = new Task();
		task.transformForCreation(taskdto,ct,userId,sprint);
		taskMap.put(taskdto.getId(),task);

		TaskActivity ta = TaskActivity.createNewFromTask(task);
		List<TaskActivity> taskActivities = new ArrayList<TaskActivity>();
		taskActivities.add(ta);
		taskActivityMap.put(taskdto.getId(),taskActivities);
		return task;
	}


	public Task updateTask(TaskDto taskdto) {
		System.out.println("updateTask called");
		taskdto.validateForUpdate();
		Long ct = System.currentTimeMillis();
		Long userId = CommonConstant.UserId;
		Task task = taskMap.get(taskdto.getId());
		task.transformForUpdate(taskdto, ct, userId);
		Task save = taskMap.put(taskdto.getId(),task);
		return save;
	}


	public Boolean disableTask(TaskDto taskdto) {
		System.out.println("disableTask called");
		taskdto.validateForDisbale();
		Long ct = System.currentTimeMillis();
		Task task= taskMap.get(taskdto.getId());
		task.setActive(Boolean.FALSE);
		 taskMap.put(taskdto.getId(),task);
		 return true;
	}


	public List<Task> getDisableTask(Long sprintId) {
		System.out.println("getDisableTask called for sprint Id: [{}]"+ sprintId);
		Util.validateLong(sprintId, "Sprint Id can't be null/empty");
		List<Task> disableTask = new ArrayList<Task>();

		Iterator taskMapIterator = taskMap.entrySet().iterator();

		while (taskMapIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)taskMapIterator.next();
			Task t = (Task) mapElement.getValue();
			if(t.getSprint().getId()==sprintId && t.getActive()==Boolean.FALSE)
				disableTask.add(t);
		}
		return Util.noRecordFoundForList(disableTask);
	}

}
