package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.BDto;

public interface BDaoService {
	public List<BDto> listDao() throws Exception;
	public void writeDao(String name, String telno, String email, String relation, String address) throws Exception;
	public BDto contentDao(int seqno) throws Exception;
	public void updateDao(int seqno, String name, String telno, String email, String relation, String address);
	public void deleteDao(int seqno) throws Exception;
	public List<BDto> listQuery(String query, String content) throws Exception;
}
