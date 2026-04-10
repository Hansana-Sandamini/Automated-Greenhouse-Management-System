package lk.ijse.cropservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CropResponseDTO {

    private Long id;
    private String name;
    private String type;
    private String season;
    private Double area;
}
