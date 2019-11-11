package com.example.MiniProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
	@Autowired
	private AssetRepository repo;
	
	public List<Tbl_asset> listAll() {
		return repo.findAll();
	}
	
	public void save(Tbl_asset tbl_asset) {
		repo.save(tbl_asset);
	}
	
	public Tbl_asset get(Long assetid) {
		return repo.findById(assetid).get();
	}
	
	public void delete(Long assetid) {
		repo.deleteById(assetid);
	}
}
