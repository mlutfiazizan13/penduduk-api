package com.app.springapi.service;

import com.app.springapi.model.Pegawai;
import com.app.springapi.repository.PegawaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PegawaiService {

    @Autowired
    private PegawaiRepository pegawaiRepository;

    public List<Pegawai>findAll(){
        return pegawaiRepository.findAll();
    }

    public List<Pegawai>findById(long id){
        return pegawaiRepository.findById(id);
    }

    public int addPegawai(String nama, boolean gender){
        return pegawaiRepository.addPegawai(nama, gender);
    }

    public int updatePegawai(String nama, boolean gender, long id){
        return pegawaiRepository.updatePegawai(nama, gender, id);
    }

    public int deletePegawai(long id){
        return pegawaiRepository.deletePegawai(id);
    }
}
