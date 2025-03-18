package com.jbt.qrstorage.common.configuration.security.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class SecurityConfigService implements ISecurityConfigService {

    private final SecurityConfigRepository securityConfigRepository;

}
