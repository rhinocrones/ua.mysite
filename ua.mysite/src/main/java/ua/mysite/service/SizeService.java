package ua.mysite.service;

import java.util.List;

import ua.mysite.entity.Size;

public interface SizeService {

	void save(int size);
	
	Size findBySize(int size);
	
	void deleteBySize(int size);
	
	List<Size> findAll();
}
