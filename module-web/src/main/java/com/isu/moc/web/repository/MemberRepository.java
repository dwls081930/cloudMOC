package com.isu.moc.web.repository;

import com.isu.moc.web.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberVO, Long> {

    public List<MemberVO> findById(String id);
    public List<MemberVO> findByName(String name);

}
