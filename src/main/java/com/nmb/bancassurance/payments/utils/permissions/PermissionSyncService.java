package com.nmb.bancassurance.payments.utils.permissions;

import com.nmb.bancassurance.shared.components.GenericPermissionSyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PermissionSyncService {
    private final GenericPermissionSyncService genericPermissionSyncService;

    @Value("${app.config.kafka.topics.permissions}")
    private String permissionsTopic;

    public void syncPermissionsToAuthService(){
        log.info("Syncing permissions to Auth Service");
        genericPermissionSyncService.syncPermissions(PaymentsPermission.values(), permissionsTopic);
        log.info("All {} Permissions synced to Auth Service successfully", PaymentsPermission.values().length);
    }
}
