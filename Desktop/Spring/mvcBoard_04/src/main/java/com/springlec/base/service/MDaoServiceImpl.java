package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.MDao;
import com.springlec.base.model.MDto;

@Service
public class MDaoServiceImpl implements MDaoService {
	@Autowired
	MDao dao;

	@Override
	public List<MDto> listDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.listDao();
	}
	
	
}
