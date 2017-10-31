package com.wikutech.workshop.jpa.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.wikutech.workshop.jpa.spring.entity.PegawaiNegeri;
import com.wikutech.workshop.jpa.spring.repository.PegawaiNegeriRepository;


@Service
public class Application {
	
	@Inject
	PegawaiNegeriRepository pnsRepository;
	
	public void runApplication() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			PegawaiNegeri pns = new PegawaiNegeri();			
			System.out.print("Nama   : "); // Title : <input>
			pns.setNama(reader.readLine());
			System.out.print("Alamat : "); // Content : <input>
			pns.setAlamat(reader.readLine());
			
			pnsRepository.save(pns);
			System.out.println("Data PNS masuk!! ID: " + pns.getNip());
			System.out.println();
		}
	}

}
