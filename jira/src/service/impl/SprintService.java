package service.impl;

import dto.SprintDto;
import entities.Sprint;
import util.CommonConstant;
import util.Util;

import java.util.HashMap;

public class SprintService {


	private static SprintService instance = null;

	private HashMap<Long, Sprint> sprintMap = new HashMap<>();



	public static SprintService getInstance()
	{
		if(instance==null)
			instance=new SprintService();
		return  instance;
	}

	public SprintDto newSprint(Long id , String name)
	{
		SprintDto dto = new SprintDto(id,name);
		return dto;
	}



	public Sprint createSprint(SprintDto task) {
		task.validateForCreate();
		Long ct = System.currentTimeMillis();
		Long userId = CommonConstant.UserId;
		Sprint sprint = Sprint.tranformForCreate(task, ct, userId);
		sprintMap.put(task.getId(), sprint);
		return sprint;

		//return sprintRepo.save(sprint);
	}

	public Sprint get(Long sprintId) {
		Util.validateLong(sprintId, "Sprint Id can't be null/empty");
		//Sprint findOne = sprintRepo.findOne(sprintId);
		return  sprintMap.get(sprintId);

	}

}
