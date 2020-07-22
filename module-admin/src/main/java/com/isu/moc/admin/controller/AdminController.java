package com.isu.moc.admin.controller;

import com.isu.moc.common.service.CommonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String WebIndex() {
        System.out.println("test adminPage!!!");
        CommonService.testMsg();
        return "/templates/adminPage.html";
    }
}
