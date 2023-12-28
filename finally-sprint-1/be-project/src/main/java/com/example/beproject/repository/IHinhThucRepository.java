package com.example.beproject.repository;

import com.example.beproject.model.HinhThuc;
import com.example.beproject.model.Student;
import com.example.beproject.model.TypeBonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface IHinhThucRepository extends JpaRepository<HinhThuc, Long> {

    @Query(value = "SELECT student_id_student FROM hinh_thuc where type_bonus_id = 2 group by student_id_student order by count(student_id_student) desc limit 5",nativeQuery = true)
    List<Long> getTopPhat();

    List<HinhThuc> findAllByStudentIdStudent(Long idStudent);

    @Query(value = "SELECT ht.student_id_student from students s left join hinh_thuc ht on s.id_student = ht.student_id_student WHERE ht.student_id_student NOT IN ( SELECT student_id_student FROM hinh_thuc where type_bonus_id = 1 group by student_id_student ) GROUP BY ht.student_id_student",nativeQuery = true)
    List<Long> getTopChuaDuocThuong();
    @Modifying
    @Transactional
    @Query(value = "UPDATE hinh_thuc SET status_id = 2 WHERE `student_id_student` = :studentId", nativeQuery = true)
    void updateHinhThucByStudentId(@Param("studentId") Long studentId);
}
