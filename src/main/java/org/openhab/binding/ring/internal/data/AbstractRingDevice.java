/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.ring.internal.data;

import org.json.simple.JSONObject;
import org.openhab.binding.ring.handler.RingDeviceHandler;
import org.openhab.binding.ring.internal.ApiConstants;
import org.openhab.binding.ring.internal.RingAccount;
import org.openhab.binding.ring.internal.RingDeviceRegistry;

/**
 * Interface common to all Ring devices.
 *
 * @author Wim Vissers - Initial contribution
 */
public abstract class AbstractRingDevice implements RingDevice {

    /**
     * The JSONObject contains the data retrieved from the Ring API,
     * or the data to send to the API.
     */
    protected JSONObject jsonObject;
    /**
     * The registration status.
     */
    private RingDeviceRegistry.Status registrationStatus;
    /**
     * The linked Ring account.
     */
    private RingAccount ringAccount;
    /**
     * The linked RingDeviceHandler.
     */
    private RingDeviceHandler ringDeviceHandler;

    public AbstractRingDevice(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    /**
     * Get the device id.
     *
     * @return the device id.
     */
    @SuppressWarnings("unchecked")
    @Override
    public String getId() {
        return jsonObject.getOrDefault(ApiConstants.DEVICE_ID, "?").toString();
    }

    /**
     * Get the device device_id.
     *
     * @return the device device_id.
     */
    @SuppressWarnings("unchecked")
    @Override
    public String getDeviceId() {
        return jsonObject.getOrDefault(ApiConstants.DEVICE_DEVICE_ID, "?").toString();
    }

    /**
     * Get the device description.
     *
     * @return the device description.
     */
    @SuppressWarnings("unchecked")
    @Override
    public String getDescription() {
        return jsonObject.getOrDefault(ApiConstants.DEVICE_DESCRIPTION, "?").toString();
    }

    /**
     * Get the device firmware version.
     *
     * @return the device firmware version.
     */
    @SuppressWarnings("unchecked")
    @Override
    public String getFirmwareVersion() {
        return jsonObject.getOrDefault(ApiConstants.DEVICE_FIRMWARE_VERSION, "?").toString();
    }

    /**
     * Get the device time zone.
     *
     * @return the device time zone.
     */
    @SuppressWarnings("unchecked")
    @Override
    public String getTimeZone() {
        return jsonObject.getOrDefault(ApiConstants.DEVICE_TIME_ZONE, "?").toString();
    }

    /**
     * Get the device kind.
     *
     * @return the device kind.
     */
    @SuppressWarnings("unchecked")
    @Override
    public String getKind() {
        return jsonObject.getOrDefault(ApiConstants.DEVICE_KIND, "?").toString();
    }

    /**
     * Get the registration status.
     *
     * @return
     */
    @Override
    public RingDeviceRegistry.Status getRegistrationStatus() {
        return registrationStatus;
    }

    /**
     * Set the registration status.
     *
     * @param status
     */
    @Override
    public void setRegistrationStatus(RingDeviceRegistry.Status registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    /**
     * Get the linked Ring Device Handler.
     *
     * @return the handler.
     */
    @Override
    public RingDeviceHandler getRingDeviceHandler() {
        return ringDeviceHandler;
    }

    /**
     * Set the linked Ring Device Handler.
     *
     * @param ringDeviceHandler the handler.
     */
    @Override
    public void setRingDeviceHandler(RingDeviceHandler ringDeviceHandler) {
        this.ringDeviceHandler = ringDeviceHandler;
    }

    /**
     * Get the linked Ring account.
     *
     * @return the account.
     */
    @Override
    public RingAccount getRingAccount() {
        return ringAccount;
    }

    /**
     * Set the linked Ring account.
     *
     * @param ringAccount
     */
    @Override
    public void setRingAccount(RingAccount ringAccount) {
        this.ringAccount = ringAccount;
    }

}
