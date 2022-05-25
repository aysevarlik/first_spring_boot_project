package com.aysevarlik.springboothomework.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//isim, soyisim, mail ve mesaj istenecek

public class CvDto {

    private long ID;
    private String name;
    private String surname;
    private String mail;
    private String message;
    private Date createdDate;

    public CvDto(long ID, String s, String s1, String s2) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.message = message;
    }
}



