package com.infra.service;

import java.util.List;

import com.infra.entity.LoginEntity;



public interface LoginService {
	
	
	 
		public LoginEntity addLoginEntityRecord(LoginEntity loginetity);
    	public Object deleteStudentRecord(int i);
    	public List<LoginEntity>  getuserById();
//		public List<LoginEntity> getListOfStudent();
    	public LoginEntity checkbyid(int id);
    	public LoginEntity  editsave(LoginEntity loginEntity);
//		public LoginEntity updateStudentRecord(LoginEntity loginentity);
    	
    	public LoginEntity getuserByIdIndividual(int id);

}
