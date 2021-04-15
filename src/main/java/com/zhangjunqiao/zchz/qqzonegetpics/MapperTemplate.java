package com.zhangjunqiao.zchz.qqzonegetpics;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperTemplate {

	private static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
	}

	private MapperTemplate() {
	}

	public static ObjectMapper getInstance() {
		return MapperTemplate.mapper;
	}

	public static <T> T mapper(String content, Class<T> type)
			throws IOException {
		return mapper.readValue(content, type);
	}

	public static <T> T mapper(String content, TypeReference<T> type)
			throws IOException {
		return mapper.readValue(content, type);
	}

	public static String writeValueAsString(Object value)
			throws JsonProcessingException {
		return mapper.writeValueAsString(value);
	}
}

class Student {

	private int id;
	private String name;
	private String TeacherName;
	private String Address;

	Student() {
	}

	Student(int id, String name, String TeacherName, String Address) {
		this.setId(id);
		this.setName(name);
		this.setTeacherName(TeacherName);
		this.setAddress(Address);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Ｏ(≧口≦)Ｏ : ");
		result.append(id + " ");
		result.append(name + " ");
		result.append(TeacherName + " ");
		result.append(Address + " ");
		return result.toString();
	}

}