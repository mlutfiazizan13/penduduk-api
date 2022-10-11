package com.app.springapi.repository;

import com.app.springapi.model.Pegawai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PegawaiRepository extends JpaRepository<Pegawai, Integer> {

    @Query(value = "SELECT * FROM m_pegawai ORDER BY id", nativeQuery = true)
    List<Pegawai> findAll();

    @Query(value = "SELECT * FROM m_pegawai WHERE id = :id", nativeQuery = true)
    List<Pegawai> findById(@Param("id") long id);

    @Modifying
    @Query(value = "INSERT INTO m_pegawai (nama, gender) VALUES (:nama, :gender)", nativeQuery = true)
    int addPegawai(@Param("nama") String nama, @Param("gender") boolean gender);

    @Modifying
    @Query(value = "UPDATE m_pegawai SET nama=:nama, gender=:gender WHERE id=:id", nativeQuery = true)
    int updatePegawai(@Param("nama") String nama, @Param("gender") boolean gender, @Param("id") long id);

    @Modifying
    @Query(value = "DELETE FROM m_pegawai WHERE id=:id", nativeQuery = true)
    int deletePegawai(@Param("id") long id);

}
