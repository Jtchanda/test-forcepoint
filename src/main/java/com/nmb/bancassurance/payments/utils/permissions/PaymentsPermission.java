package com.nmb.bancassurance.payments.utils.permissions;

import com.nmb.bancassurance.shared.interfaces.PermissionProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentsPermission implements PermissionProvider {
    CREATE_PAYMENT("banc500", "Record a new payment"),
    READ_PAYMENT("banc501", "Read payment details"),
    UPDATE_PAYMENT("banc502", "Update payment information"),
    DELETE_PAYMENT("banc503", "Delete a payment record");

    private final String permission;
    private final String description;

    @Override
    public String getFeature() {
        return "payments";
    }

    @Override
    public String getService() {
        return "PAYMENTS";
    }
}
