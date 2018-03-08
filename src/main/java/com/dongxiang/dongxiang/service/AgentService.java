package com.dongxiang.dongxiang.service;

import com.dongxiang.dongxiang.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    @Autowired
    public AgentRepository agentRepository;
}
