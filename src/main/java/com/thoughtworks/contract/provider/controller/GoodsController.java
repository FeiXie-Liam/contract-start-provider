package com.thoughtworks.contract.provider.controller;

import com.thoughtworks.contract.provider.entity.Goods;
import com.thoughtworks.contract.provider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Goods goods) {
        Long goodsId = goodsService.add(goods);
        return ResponseEntity.created(URI.create("/goods/"+goodsId)).build();
    }
}
