package com.hotel.app.advanced.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Amenities {

    private boolean withPool;
    private boolean withGym;
    private boolean isGreenProperty;
    private boolean withKitchen;
    private boolean isEVC;


}
