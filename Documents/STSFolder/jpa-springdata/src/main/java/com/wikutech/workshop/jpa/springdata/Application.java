package com.wikutech.workshop.jpa.springdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wikutech.workshop.jpa.springdata.entity.SiswaXiRpl;
import com.wikutech.workshop.jpa.springdata.repository.SiswaXiRplRepository;

@Service
public class Application {
	@Inject
	private SiswaXiRplRepository siswaXiRplRepository;
	
	@PostConstruct
	public void runApplication() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1. Search siswa");
			System.out.println("2. Add siswa");
			System.out.print("Your choice (1): ");
			
			String answer = reader.readLine();
			if (answer.equalsIgnoreCase("2")) {
				addSiswa(reader);
			} else {
				findSiswaByNama(reader);
			}
		}
	}
	
	private void addSiswa(BufferedReader reader) throws IOException {
		SiswaXiRpl siswa = new SiswaXiRpl();
				
		System.out.print("NIS   : "); // Title : <input>
		siswa.setNis(reader.readLine());
		System.out.print("Nama : "); // Content : <input>
		siswa.setNama(reader.readLine());
		System.out.print("Alamat : "); // Content : <input>
		siswa.setAlamat(reader.readLine());
		
		siswaXiRplRepository.save(siswa);
		System.out.println("Siswa submitted! ID: " + siswa.getId());
		System.out.println();
	}
	
	private void findSiswaByNama(BufferedReader reader) throws IOException {
		System.out.print("Search : ");
		List<SiswaXiRpl> siswa = siswaXiRplRepository.findByNama(reader.readLine());
		
		for (SiswaXiRpl n : siswa) {
			System.out.println("ID      : " + n.getId());
			System.out.println("ID      : " + n.getNis());
			System.out.println("TITLE   : " + n.getNama());
			System.out.println("CONTENT : " + n.getAlamat());
			System.out.println();
		}
	}
}
