package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.BDao;
import com.springlec.base.model.BDto;

@Service
public class BDaoServiceImpl implements BDaoService{
	
	@Autowired
	BDao dao;
	
	@Override
	public List<BDto> listDao() throws Exception {
		
		return dao.listDao();
	
	
	}

	@Override
	public void writeDao(String bName, String bTitle, String bContent) throws Exception {
		// TODO Auto-generated method stub
		dao.writeDao(bName, bTitle, bContent);
		
	}

	@Override
	public BDto contentDao(int bId) throws Exception {
		// TODO Auto-generated method stub
		return dao.contentDao(bId);
	}

	@Override
	public void updateDao(int bId, String bName, String bTitle, String bContent) throws Exception {
		// TODO Auto-generated method stub
		dao.updateDao(bId, bName, bTitle, bContent);
	}

	@Override
	public void deleteDao(int bId) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteDao(bId);
		
	}
}
