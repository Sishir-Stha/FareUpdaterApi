package com.api.fareupdater.updater.controller;

import com.api.fareupdater.common.constants.ApiConstants;
import com.api.fareupdater.updater.Service.UpdaterService;
import com.api.fareupdater.updater.dto.response.FareData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.UPDATER_BASE)
public class UpdaterController {

    @Autowired
    private UpdaterService updaterService;

    @PostMapping("/getFareData")
    public ResponseEntity<List<FareData>> getFareData()
}
