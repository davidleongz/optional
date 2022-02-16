package com.david.optional.demo;

import com.david.optional.dto.ComputerDTO;
import com.david.optional.dto.MemberCardDTO;
import com.david.optional.dto.SoundcardDTO;
import com.david.optional.dto.UsbDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.david.optional.dto.MembershipLevelEnum.GOLD;
import static com.david.optional.dto.MembershipLevelEnum.PLATINUM;

@Slf4j
public class OptionalWithMapFlatMapAndFilterDemo {

    public static void main(String[] args) {

        extractUsbVersionWithFlatMap();

        rejectingValuesUsingFilterMethod();

        extractingAndTransformingValuesUsingMapMethod();

        MemberCardDTO card = new MemberCardDTO("1");
        getDiscountWithoutOptional(card);
        getDiscountWithOptional(card);

    }

    private static void extractUsbVersionWithFlatMap() {

        Optional<ComputerDTO> computer = Optional.of(new ComputerDTO());

        String version = "UNKNOWN";
        if (computer != null) {
            SoundcardDTO soundcard = computer.get().getSoundcard().get();
            if (soundcard != null) {
                UsbDTO usb = soundcard.getUsb().get();
                if (usb != null) {
                    version = usb.getVersion().get();
                }
            }
        }

        String versionOptional = computer.flatMap(ComputerDTO::getSoundcard)
                .flatMap(SoundcardDTO::getUsb)
                .flatMap(UsbDTO::getVersion)
                .orElse("UNKNOWN");

        String versionOptionalWithException = computer.flatMap(ComputerDTO::getSoundcard)
                .flatMap(SoundcardDTO::getUsb)
                .flatMap(UsbDTO::getVersion)
                .orElseThrow(IllegalStateException::new);

    }


    private static void rejectingValuesUsingFilterMethod() {

        UsbDTO usbDTO = new UsbDTO();
        if (usbDTO != null && "3.0".equals(usbDTO.getVersion())) {
            log.info("ok");
        }

        Optional<UsbDTO> maybeUsbWithFilter = Optional.ofNullable(new UsbDTO());
        maybeUsbWithFilter.filter(usb -> "3.0".equals(usb.getVersion())).ifPresent(usb -> log.info("ok"));
    }


    private static void extractingAndTransformingValuesUsingMapMethod() {

        Optional<SoundcardDTO> maybeSoundCard = Optional.of(new SoundcardDTO());
        Optional<UsbDTO> usb = maybeSoundCard.flatMap(SoundcardDTO::getUsb);

        maybeSoundCard.flatMap(SoundcardDTO::getUsb)
                .filter(usbMap -> "3.0".equals(usbMap.getVersion())).ifPresent(usbMap -> log.info("ok"));

    }


    private static Double getDiscountWithoutOptional(MemberCardDTO card) {

        if (PLATINUM.equals(card.getLevel())) {
            return 10.0D;
        } else if (GOLD.equals(card.getLevel())) {
            return 5.0D;
        }

        return null;
    }

    private static Optional<Double> getDiscountWithOptional(MemberCardDTO card) {

        if (PLATINUM.equals(card.getLevel())) {
            return Optional.of(10.0D);
        } else if (GOLD.equals(card.getLevel())) {
            return Optional.of(5.0D);
        }
        return Optional.empty();
    }

}
