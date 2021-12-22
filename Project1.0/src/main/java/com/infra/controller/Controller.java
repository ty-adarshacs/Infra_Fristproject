package com.infra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.infra.entity.Data;
import com.infra.entity.Student;
import com.infra.service.Service;

//@RestController
public class Controller {
	@Autowired
	Service service;

	@PostMapping(path = "/addStudentRecord")
	public Object adde(@RequestBody Student student) {
		Data data = new Data();
		Student ss = service.addStudentRecord(student);
		System.out.println(ss);
		if (ss != null) {
			data.setMessage("data inserted suceffully");
			data.setObj(ss);
		} else {
			data.setMessage("data already present in databas");
			data.setObj("sorry");
		}

		return data;

	}

	@DeleteMapping(path = "/deleteStudentRecord/{id}")
	public Data delete(@PathVariable("id") int stuid) {

		Data data = new Data();
		Object ss = service.deleteStudentRecord(stuid);
		System.out.println(" result is " + ss);
		if (ss == "ok") {
			data.setMessage(" deleted  record suceffully ");
			data.setObj("deleted");

		} else {
			data.setMessage(" not deleted record ");
			data.setObj("not deleted");
		}

		return data;
	}

	@GetMapping(path = "/getStudentById/{id}")
	public Data getStudentRecord(@PathVariable("id") int stuid) {
		Data data = new Data();
		try {

			Student s = service.getstudentById(stuid);
			if (s != null) {
				data.setMessage(" data fetchig suceffully");
				data.setObj(s);
			} else {
				data.setMessage(" data not present in database");
				data.setObj("sorry");
			}

		} catch (Exception e) {
			data.setMessage(" data not fetching ");
			data.setObj("No");
		}
		return data;

	}

	@PostMapping(path = "/updateStudent")
	public Data updateStudetRecord(@RequestBody Student student) {
		Data data = new Data();
		try {
			Student s = service.updateStudentRecord(student);
			if (s != null) {
				data.setMessage("data updated suceffully");
				data.setObj(s);
			} else {
				data.setMessage("not updtaded sucefuuly ");
				data.setObj(student);
			}
		} catch (Exception e) {
			System.out.println(" nothing is printed ");
			e.printStackTrace();
		}

		return data;
	}

	@GetMapping(path = "/getallStudentrecord")
	public Data getAllStudent() {
		Data data = new Data();
		try {
			List<Student> list = service.getListOfStudent();
			if (!list.isEmpty()) {
				data.setMessage("List of Student Record");
				data.setObj(list);
			} else {
				data.setMessage("List of Student not present Record");
				data.setObj("sorry no record is present");
			}

		} catch (Exception e) {
			data.setMessage("List of Student not present Record");
			data.setObj("sorry no record is present");
		}

		return data;

	}

}
