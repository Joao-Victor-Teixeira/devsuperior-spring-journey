package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSumDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Transactional(readOnly = true)
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<SaleReportDTO> getReport(String minDate, String maxDate, String name, Pageable pageable){
		LocalDate max;
        if (maxDate.equals("")) {
            max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        } 
		else {
            max = LocalDate.parse(maxDate);
        }
        LocalDate min;
        if (minDate.equals("")) {
            min = max.minusYears(1L); 
        } 
		else {
            min = LocalDate.parse(minDate);
        }
        Page<Sale> result = repository.searchSales(min, max, name, pageable);
        return result.map(x -> new SaleReportDTO(x));
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> getSummary(String minDate, String maxDate){
        LocalDate max;
        if (maxDate.equals("")) {
            max = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        } 
		else {
            max = LocalDate.parse(maxDate);
        }
        LocalDate min;
        if (minDate.equals("")) {
            min = max.minusYears(1L);
        } 
		else {
            min = LocalDate.parse(minDate);
        }
        return repository.amountGroupedBySeller(min, max);
    }
	
}
