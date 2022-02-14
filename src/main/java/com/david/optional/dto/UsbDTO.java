package com.david.optional.dto;

import java.util.Optional;

public class UsbDTO {

    public Optional<String> getVersion() {
        return Optional.of("GOOD");
    }
}
