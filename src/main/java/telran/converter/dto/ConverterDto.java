package telran.converter.dto;

import java.time.LocalDate;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ConverterDto {
    boolean success;
    long timestamp;
    String base;
    @JsonFormat
    LocalDate date;
    HashMap<String, Double> rates;
  
}
