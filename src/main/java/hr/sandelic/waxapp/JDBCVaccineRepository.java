package hr.sandelic.waxapp;


import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class JDBCVaccineRepository implements VaccineRepository{

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert vaccineInserter;

    public JDBCVaccineRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.vaccineInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("vaccine")
                .usingGeneratedKeyColumns("vaccine_id");
    }


    @Override
    public List<Vaccine> findAll() {
        return jdbc.query("select vaccine_id, researchName, manufacturersName, vaccineType, requiredDosage, availableDosageCount from vaccine",
                this::mapRowToVaccine);
    }

    @Override
    public Optional<Vaccine> findVaccineByManufacturersName(String manufacturersName) {
        return Optional.ofNullable(jdbc.queryForObject("select vaccine_id, researchName, manufacturersName, vaccineType, requiredDosage, availableDosageCount from vaccine where manufacturersName = ?",
                this::mapRowToVaccine, manufacturersName));
    }

    @Override
    public Vaccine addNewVaccine(Vaccine vaccine) {

        vaccine.setId(saveVaccineDetails(vaccine));

       String addQuery = "INSERT INTO vaccine (vaccine_id, researchName, manufacturersName, vaccineType, requiredDosage, availableDosageCount) VALUES (?, ? , ?, ?, ?, ?)";
       jdbc.update(addQuery, vaccine.getId(), vaccine.getResearchName(), vaccine.getManufacturersName(), vaccine.getVaccineType(), vaccine.getRequiredDosage(), vaccine.getAvailableDosageCount());

        return vaccine;
    }

    @Override
    public void deleteVaccineByManufacturersName(String manufacturersName) {
        String deleteQuery = "delete from vaccine where manufacturersName = ?";
        jdbc.update(deleteQuery, manufacturersName);
    }


    private long saveVaccineDetails(Vaccine vaccine){
        Map<String, Object> values = new HashMap<>();
        values.put("researchName", vaccine.getResearchName());
        values.put("manufacturersName", vaccine.getManufacturersName());
        values.put("vaccineType", vaccine.getVaccineType());
        values.put("requiredDosage", vaccine.getRequiredDosage());
        values.put("availableDosageCount", vaccine.getAvailableDosageCount());
       return vaccineInserter.executeAndReturnKey(values).longValue();
    }

    private Vaccine mapRowToVaccine (ResultSet rs, int rowNumber) throws SQLException{
        Vaccine vaccine = new Vaccine();
        vaccine.setId(rs.getLong("vaccine_id"));
        vaccine.setResearchName(rs.getString("researchName"));
        vaccine.setManufacturersName(rs.getString("manufacturersName"));
        vaccine.setVaccineType(rs.getString("vaccineType"));
        vaccine.setRequiredDosage(rs.getInt("requiredDosage"));
        vaccine.setAvailableDosageCount(rs.getInt("availableDosageCount"));
        return vaccine;
    }


}
