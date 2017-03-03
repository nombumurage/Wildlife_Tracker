import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

public class Sighting {
  private int animalId;
  private int id;
  private String rangerName;
  private String location;
  private Timestamp recordedTime;
  public Sightings(String rangerName, String location) {
    this.rangerName = rangerName;
    this.location = location;
  }

  public String getRangerName(){
    return rangerName;
  }
  public String getLocation(){
    return location;
  }
  public int getId(){
    return id;
  }
  public int getAnimalId(){
    return animalId;
  }
  public Timestamp getRecordedTime(){
    return recordedTime;
  }

  public static List<Person> all() {
    String sql = "SELECT id, rangerName, location, recordedTime FROM sightings ";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Person.class);
    }
  }

  @Override
  public boolean equals(Object otherSighting){
    if (!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getName().equals(newSighting.getName()) &&
             this.getEmail().equals(newSighting.getEmail());
    }
  }
  @Override
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO persons (name, email) VALUES (:name, :email)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("email", this.email)
        .executeUpdate()
        .getKey();
    }
  }




}
