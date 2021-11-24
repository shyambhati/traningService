package com.technical99.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical99.dao.TutorialMasterDao;
import com.technical99.entity.TutorialMaster;
import com.technical99.service.TutorialMasterService;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class TutorialMasterServiceImpl implements TutorialMasterService{

	@Autowired
	private TutorialMasterDao dao;
	
	@Override
	public List<TutorialMaster> getlist() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
