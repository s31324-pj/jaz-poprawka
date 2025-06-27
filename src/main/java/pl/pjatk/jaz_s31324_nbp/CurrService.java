package pl.pjatk.jaz_s31324_nbp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrService {

    private final RestTemplate rest = new RestTemplate();
    private final String url = "http://api.nbp.pl/api/exchangerates/tables/A/{code}?start={start}&end={end}&format=json";

    @Autowired
    private TableLogRepository  repository;

    public List<Table> getRates(String code, LocalDate start, LocalDate end) {
        try {

            Table[] tables = rest.getForObject(url, Table[].class, code, start, end);

            if (tables == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nie ma takich danych");
            }

            TableLog log = new TableLog();
            log.setCode(code);
            log.setStart(start);
            log.setEnd(end);
            log.setCurrTime(LocalDateTime.now());
            repository.save(log);

            List<Table> result = new ArrayList<>();
            for (Table table : tables) {
                List<Rate> filteredRates = new ArrayList<>();
                for (Rate rate : table.getRates()) {
                    if (rate.getCode().equalsIgnoreCase(code)) {
                        filteredRates.add(rate);
                    }
                }
                if (!filteredRates.isEmpty()) {
                    table.setRates(filteredRates);
                    result.add(table);
                }
            }
            return result;

        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Błąd pobierania danych: " + e.getMessage());
        }
    }

}
