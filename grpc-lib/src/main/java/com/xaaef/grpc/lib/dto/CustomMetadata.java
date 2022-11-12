package com.xaaef.grpc.lib.dto;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomMetadata implements java.io.Serializable {

    private String id;

    private Integer size;

    private LocalDate date;

    private LocalTime time;

    private LocalDateTime dateTime;

    private Double d1;

    private List<String> list;

    private Map<String, Object> maps;

}
