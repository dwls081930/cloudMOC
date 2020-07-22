package com.isu.moc.web.controller;

import com.isu.moc.web.service.MemberService;
import com.isu.moc.web.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class WebController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MemberService memberService;

    @RequestMapping("/index")
    public String templateTest(Model model) {
        model.addAttribute("text", "boot");

        return "index";
    }

    @RequestMapping("/cError")
    public String createErrorTest(Model model) throws Exception {
        if( true ) {
            throw new Exception("Error create");
        }
        return "error";
    }

    @RequestMapping("/findMember")
    public String getMember(@RequestParam("mbrNo") Long mbrNo) throws Exception {
        logger.info("Start getMember() ---------------------------------");

        Optional<MemberVO> member = memberService.findById(mbrNo);

        logger.info("End getMember() ---------------------------------");
        return "index";
    }
}
