package com.david.optional.dto;

import java.util.Optional;

public class ComputerDTO {

    private Optional<SoundcardDTO> soundcard;

    public Optional<SoundcardDTO> getSoundcard() {
        return soundcard;
    }
}
