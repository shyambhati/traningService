package com.technical99.service;

import java.util.List;
import org.hibernate.engine.jdbc.batch.spi.Batch;

import com.technical99.entity.BatchMaster;

public interface BatchService {
	
	public List<BatchMaster> getlist();	
	
	
}
