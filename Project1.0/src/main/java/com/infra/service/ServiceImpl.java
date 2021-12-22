package com.infra.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.infra.entity.Student;
import com.infra.repository.Repo;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	Repo repo;

	@Override
	public Student addStudentRecord(Student s1) {

		try {
			int i = s1.getId();
			System.out.println("id is " + i);
			Student sd = repo.findById(i).get();
			if (sd != null) {
				return null;
			}

		} catch (Exception e) {
			return repo.save(s1);

		}

		return null;
	}

	public Object deleteStudentRecord(int i) {

		try {
//			Student ss = repo.findById(i).get();
			repo.deleteById(i);
			return "ok";
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public Student getstudentById(int i) {

		try {
			System.out.println("get by id");
			return repo.findById(i).get();
		} catch (Exception e) {
			return null;

		}

	}

//	@Override
//	public Student getUpdateById(Student student) {
//		int i=student.getId();
//		
//		return null;
//	}

	@Override
	public List<Student> getListOfStudent() {
		List<Student> list=repo.findAll();
		try {
			if(list.isEmpty()) {
				return null;
			}else {
				return list;
			}
		}catch(Exception e) {
			return null;
		}
	
	}

	@Override
	public Student updateStudentRecord(Student student) {
        int id= student.getId();
        System.out.println("id is :"+id);
        
		try {
			Student s=repo.findById(id).get();
			System.out.println(" s :"+s);
			if(s!=null) {
				return repo.save(student);
			}else {
				return null;
			}
		}catch(Exception e) {
			return null;
		}
		

		
			
	
	}
	}

