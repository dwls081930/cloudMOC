package com.isu.moc.web.vo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Member;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member")
public class MemberVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mbrNo;
    private String id;
    private String name;

    @Builder
    public MemberVO(String id, String name) { this.id = id; this.name = name; }

    public MemberVO(MemberVO memberVO) {
        super();
    }

    public MemberVO() {super();}
}
