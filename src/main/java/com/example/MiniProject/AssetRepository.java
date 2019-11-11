package com.example.MiniProject;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MiniProject.Tbl_asset;

public interface AssetRepository extends JpaRepository<Tbl_asset, Long> {

}
