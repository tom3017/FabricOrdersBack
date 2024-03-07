package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.BDao;
import com.springlec.base.model.BDto;


@Service
public class BDaoServiceImpl implements BDaoService {
	
	@Autowired
	BDao dao;
	
	
	@Override
	public List<BDto> listDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.listDao();
	}


	@Override
	public void writeDao(String name, String telno, String email, String relation, String address) throws Exception {
		// TODO Auto-generated method stub
		dao.writeDao(name, telno, email, relation, address);
		
	}


	@Override
	public BDto contentDao(int seqno) throws Exception {
		// TODO Auto-generated method stub
		return dao.contentDao(seqno);
	}


	@Override
	public void updateDao(int seqno, String name, String telno, String email, String relation, String address) {
		// TODO Auto-generated method stub
		dao.updateDao(seqno, name, telno, email, relation, address);
		
	}


	@Override
	public void deleteDao(int seqno) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteDao(seqno);
	}


	@Override
	public List<BDto> listQuery(String query, String content) throws Exception {
		// TODO Auto-generated method stub
		content = '%' + content + '%';
		return dao.listQuery(query, content); 
	}

}
