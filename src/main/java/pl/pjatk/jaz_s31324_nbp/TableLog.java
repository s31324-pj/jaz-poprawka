package pl.pjatk.jaz_s31324_nbp;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "table_log")
public class TableLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private LocalDate start;
    private LocalDate end;
    private LocalDateTime currTime;

    public TableLog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String currency) {
        this.code = currency;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public LocalDateTime getCurrTime() {
        return currTime;
    }

    public void setCurrTime(LocalDateTime currTime) {
        this.currTime = currTime;
    }
}
