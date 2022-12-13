package ync.pyb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailDTO {

    private Long detailId;
    private String detailIncluded;
    private String detailNotIncluded;
    private String detailNotice;
}
