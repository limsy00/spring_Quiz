package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	// input: 4개 파라미터
	// output: insert 했던 entity (CompanyEntity)
	public CompanyEntity addCompany(String name, String business,
			String scale, int headcount) {
		
		return companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	// input: id, scale, headcount
	// output: CompanyEntity
	public CompanyEntity updateCompanyById(int id, String scale, int headcount) {
		// 기존 데이터 조회
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		if (company != null) {
			company = companyRepository.save(company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build());
		}
		
		return company;
	}
	
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}

}
