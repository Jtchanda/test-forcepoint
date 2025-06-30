package com.nmb.bancassurance.payments.utils.permissions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PermissionSyncInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final PermissionSyncService permissionSyncService;

    @Value("${app.config.sync.permissions.enabled}")
    private boolean syncEnabled;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
       var application = event.getSpringApplication();
         if (!syncEnabled) {
              log.info("Permission sync is disabled, skipping sync to Auth Service");
              return;
         }
       log.info("Application {} is ready, syncing permissions to Auth Service", application.getMainApplicationClass().getSimpleName());
       permissionSyncService.syncPermissionsToAuthService();
    }
}
