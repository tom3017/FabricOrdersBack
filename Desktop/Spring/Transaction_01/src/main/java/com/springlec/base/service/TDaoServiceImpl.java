package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.TDao;

// 여기서 트랜젝션이 들어간다

@Service
@Transactional(rollbackFor = Exception.class)
public class TDaoServiceImpl implements TDaoService {
	
	@Autowired
	TDao dao;
	
	
	@Override
	public void writeDao(String id, String product) throws Exception {
		// TODO Auto-generated method stub
		dao.writeDao(id, product);
		dao.writeDao2(id);

	}
	
	

//	@Override
//	public void writeDao2(String id) throws Exception {
//		// TODO Auto-generated method stub
//		dao.writeDao2(id);
//		
//	}

}
