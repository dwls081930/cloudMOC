package com.isu.moc.web.service;

import com.isu.moc.web.repository.MemberRepository;
import com.isu.moc.web.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("memberService")
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Optional<MemberVO> findById(Long mbrNo) {
        Optional<MemberVO> member = memberRepository.findById(mbrNo);
        return member;
    }

    public MemberVO save(MemberVO member) {
        memberRepository.save(member);
        return member;
    }

}
