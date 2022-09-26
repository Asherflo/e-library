package com.asherflo.elibrary.models;

import com.asherflo.elibrary.models.enums.AgeRate;
import com.asherflo.elibrary.models.enums.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private  String author;
    private String description;
    private String coverImageFileName;
    private String fileName;

@Enumerated(EnumType.STRING)
    private AgeRate ageRate;
    private  String upLoadedBy;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateUploaded;
@Enumerated(EnumType.STRING)
    private Category category;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", coverImageFileName='" + coverImageFileName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", ageRate=" + ageRate +
                ", upLoadedBy='" + upLoadedBy + '\'' +
                ", dateUploaded=" + dateUploaded +
                ", category=" + category +
                '}';
    }
}
