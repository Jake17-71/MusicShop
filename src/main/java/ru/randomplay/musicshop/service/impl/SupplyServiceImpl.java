package ru.randomplay.musicshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.randomplay.musicshop.dto.create.SupplyCreateRequest;
import ru.randomplay.musicshop.dto.response.SupplyResponse;
import ru.randomplay.musicshop.entity.Supply;
import ru.randomplay.musicshop.entity.SupplyItem;
import ru.randomplay.musicshop.entity.WarehouseManager;
import ru.randomplay.musicshop.mapper.SupplyMapper;
import ru.randomplay.musicshop.repository.SupplyRepository;
import ru.randomplay.musicshop.service.SupplyService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {
    private final SupplyRepository supplyRepository;
    private final SupplyMapper supplyMapper;

    @Override
    public List<SupplyResponse> getAll() {
        return supplyMapper.toSupplyResponseList(supplyRepository.findAllWithWarehouseManagerAndProducts());
    }

    @Override
    @Transactional
    public void create(SupplyCreateRequest supplyCreateRequest, WarehouseManager warehouseManager) {
        Supply supply = new Supply();
        supply.setWarehouseManager(warehouseManager);
        Set<SupplyItem> supplyItems = supplyMapper.toSupplyItemSet(supplyCreateRequest, supply);
        supply.setSupplyItems(supplyItems);
        supplyRepository.save(supply);
    }
}
