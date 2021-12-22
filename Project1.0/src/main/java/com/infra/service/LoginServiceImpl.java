package com.infra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infra.entity.LoginEntity;

import com.infra.repository.LoginEntityRepo;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginEntityRepo loginEntityRepo;

	@Override
	public LoginEntity addLoginEntityRecord(LoginEntity loginetity) {

		System.out.println("LoginEntity  details");
		System.out.println(loginetity.getId());
		System.out.println(loginetity.getName());
		System.out.println(loginetity.getAdress());
		System.out.println(loginetity.getPincode());
//			int i = s1.getId();
//			System.out.println("id is " + i);
//			Student sd = repo.findById(i).get();
//			if (sd != null) {
//				return null;
//			}
//
//		} catch (Exception e) {
//			return repo.save(s1);
//
//		}
//
//		return null;
//	}
		try {
			Integer loginId = loginetity.getId();
			System.out.println("loginId is : " + loginId);
			try {
				LoginEntity logindetails = loginEntityRepo.findById(loginId).get();
			} catch (Exception e) {
				System.out.println(" storing suceffully");
				return loginEntityRepo.save(loginetity);
			}
			LoginEntity logindetails = loginEntityRepo.findById(loginId).get();
//			System.out.println("loginEntityDetails : "+logindetails.toString());
			if (logindetails == null) {
				return loginEntityRepo.save(loginetity);
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Error is : " + e.getMessage());
			return null;
		}

		// TODO Auto-generated method stub

	}

	@Override
	public Object deleteStudentRecord(int loginid) {

		try {
			LoginEntity logindetails = (LoginEntity) loginEntityRepo.findById(loginid).get();
			try {
				if (logindetails != null) {
					loginEntityRepo.deleteById(loginid);
					return "ok";
				} else {
					return null;
				}

			} catch (Exception e) {
				return null;
			}

		} catch (Exception e) {
			System.out.println(" Error is " + e.getMessage());
			return null;

		}

	}

	@Override
	public List<LoginEntity> getuserById() {
		

		try {
			System.out.println("enter inside the get  by id");
			return loginEntityRepo.findAll();
		}catch(Exception e) {
			return null;
		}

		
	}

	@Override
	public LoginEntity checkbyid(int id) {
		try {
			return loginEntityRepo.findById(id).get();
		}catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public LoginEntity editsave(LoginEntity loginEntity) {
		
		return loginEntityRepo.save(loginEntity);
	}

	@Override
	public LoginEntity getuserByIdIndividual(int id) {
		
		return loginEntityRepo.findById(id).get();
	}

	
	

}
