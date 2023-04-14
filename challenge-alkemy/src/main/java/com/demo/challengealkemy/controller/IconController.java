package com.demo.challengealkemy.controller;


import com.demo.challengealkemy.dto.icon.CreateOrUpdateIconDTO;
import com.demo.challengealkemy.dto.icon.IconDTO;
import com.demo.challengealkemy.helper.ApiHelper;
import com.demo.challengealkemy.helper.ResponseBase;
import com.demo.challengealkemy.service.interfaces.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon")
public class IconController {

    @Autowired
    private IconService service;

    @GetMapping("/get-all-icons")
    public ResponseEntity<List<IconDTO>> getIcons() {
        List<IconDTO> icons = ApiHelper.IconEntityToIconDTO(service.getAllIcons());
        return ResponseEntity.ok(icons);
    }

    @PostMapping("/create-icon")
    public ResponseBase createIcon(@RequestBody CreateOrUpdateIconDTO iconDTO) {
        return service.createIcon(iconDTO);
    }

    @PutMapping("/update-icon/{id}")
    public ResponseBase updateIcon(@PathVariable Long id, @RequestBody CreateOrUpdateIconDTO iconDTO) {
        return service.updateIcon(id, iconDTO);
    }

}
