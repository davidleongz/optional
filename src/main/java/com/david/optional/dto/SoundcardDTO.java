package com.david.optional.dto;

import java.util.Optional;

public class SoundcardDTO {

    private Optional<UsbDTO> usb;

    public Optional<UsbDTO> getUsb() {
        return usb;
    }
}
