package com.balance.balance.service;

import com.balance.balance.repository.SpendingGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SpendingGroupService {

    @Autowired
    private SpendingGroupRepository spendingGroupRepository;
}
