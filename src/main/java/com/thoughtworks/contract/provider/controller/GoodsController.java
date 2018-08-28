package com.thoughtworks.contract.provider.controller;

import com.thoughtworks.contract.provider.entity.Goods;
import com.thoughtworks.contract.provider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity add(@RequestBody Goods goods, @PathVariable Long id) {
        Long goodsId = goodsService.add(goods);
//        return ResponseEntity.created(URI.create("/goods/" + goodsId)).build();
        Map map = new HashMap();
        map.put("id", goodsId);
        return new ResponseEntity(map, HttpStatus.CREATED);
    }
}
