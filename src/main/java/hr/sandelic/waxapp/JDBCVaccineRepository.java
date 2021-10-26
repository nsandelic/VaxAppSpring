package hr.sandelic.waxapp;


import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
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
        return jdbc.query("select vaccine_id, research_name, manufacturers_name, vaccine_type, required_dosage, available_dosage_count from vaccine",
                this::mapRowToVaccine);
    }

    @Override
    public Optional<Vaccine> findVaccineByManufacturersName(String manufacturersName) {
        return Optional.ofNullable(jdbc.queryForObject("select vaccine_id, research_name, manufacturers_name, vaccine_type, required_dosage, available_dosage_count from vaccine where manufacturers_name = ?",
                this::mapRowToVaccine, manufacturersName));
    }

    @Override
    public Vaccine addNewVaccine(Vaccine vaccine) {

        Vaccine nullVaccine = null;
        try {
            String addQuery = "INSERT INTO vaccine ( research_name, manufacturers_name, vaccine_type, required_dosage, available_dosage_count) VALUES (? , ?, ?, ?, ?)";
            jdbc.update(addQuery, vaccine.getResearchName(), vaccine.getManufacturersName(), vaccine.getVaccineType(), vaccine.getRequiredDosage(), vaccine.getAvailableDosageCount());
            return vaccine;
        }
        catch( Exception e ) {
            return nullVaccine;
        }
    }

    @Override
    public void deleteVaccineByManufacturersName(String manufacturersName) {

        Vaccine vaccine = jdbc.queryForObject("select vaccine_id, research_name, manufacturers_name, vaccine_type, required_dosage, available_dosage_count from vaccine where manufacturers_name = ?",
                this::mapRowToVaccine, manufacturersName);


        String deleteQuery1 = "delete  from side_effect where vaccine_id = ?";
        jdbc.update(deleteQuery1, vaccine.getId());

        String deleteQuery2 = "delete  from vaccine where manufacturers_name = ?";
        jdbc.update(deleteQuery2, manufacturersName);
    }


    private long saveVaccineDetails(Vaccine vaccine){
        Map<String, Object> values = new HashMap<>();
        values.put("research_name", vaccine.getResearchName());
        values.put("manufacturers_name", vaccine.getManufacturersName());
        values.put("vaccine_type", vaccine.getVaccineType());
        values.put("required_dosage", vaccine.getRequiredDosage());
        values.put("available_dosage_count", vaccine.getAvailableDosageCount());
       return vaccineInserter.executeAndReturnKey(values).longValue();
    }

    private Vaccine mapRowToVaccine (ResultSet rs, int rowNumber) throws SQLException{
        Vaccine vaccine = new Vaccine();
        vaccine.setId(rs.getLong("vaccine_id"));
        vaccine.setResearchName(rs.getString("research_name"));
        vaccine.setManufacturersName(rs.getString("manufacturers_name"));
        vaccine.setVaccineType(rs.getString("vaccine_type"));
        vaccine.setRequiredDosage(rs.getInt("required_dosage"));
        vaccine.setAvailableDosageCount(rs.getInt("available_dosage_count"));
        return vaccine;
    }


}
