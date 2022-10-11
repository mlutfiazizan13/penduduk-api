package com.app.springapi.controller;

import com.app.springapi.model.Pegawai;
import com.app.springapi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pegawai")
public class PegawaiController {

    @Autowired
    public PegawaiService pegawaiService;


    @GetMapping("/")
    public List<Pegawai>findAll(){
        return pegawaiService.findAll();
    }

    @GetMapping("/{id}")
    public List<Pegawai>findById(@PathVariable long id){
        return pegawaiService.findById(id);
    }

    @PostMapping("/addPegawai")
    public String addPegawai(@RequestBody Pegawai pegawai){
        pegawaiService.addPegawai(pegawai.getNama(), pegawai.getGender());
        return "add new pegawai success";
    }

    @PutMapping("/editPegawai")
    public String updatePegawai(@RequestBody Pegawai pegawai) {
        pegawaiService.updatePegawai(pegawai.getNama(), pegawai.getGender(), pegawai.getId());
        return "update pegawai success";
    }

    @DeleteMapping("/deletePegawai")
    public String deletePegawai(@RequestBody Pegawai pegawai){
        pegawaiService.deletePegawai(pegawai.getId());
        return "delete pegawai success";
    }

}
