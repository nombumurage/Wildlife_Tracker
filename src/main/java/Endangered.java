import java.util.*;
import org.sql2o.*;
import java.sql.Timestamp;

public class Endangered extends Animal{
  private String age;
  private String health;
  private String type;

  public static final String [] HEALTHS = new String[] {"healthy", "ill", "okay"};
  public static final String [] AGE = new String[]{"newborns", "young", "adult"};
  public static final String ANIMAL_TYPE = "Endangered";

  public Endangered(String name, String type, String age, String health) {
    this.name = name;
    this.type = ANIMAL_TYPE;
    this.age = age;
    this.health = health;
  }
  public String getHealth(){
    return health;
  }
  public String getAge(){
    return age;
  }
  public String getType(){
    return type;
  }
  public static List<Endangered> all() {
  String sql = "SELECT * FROM animals WHERE type='Endangered';";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql)
    .throwOnMappingFailure(false)
    .executeAndFetch(Endangered.class);
    }
  }
  public static Endangered find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM animals where id=:id";
    Endangered endangered = con.createQuery(sql)
      .addParameter("id", id)
      .throwOnMappingFailure(false)
      .executeAndFetchFirst(Endangered.class);
      return monster;
    }
  }
  @Override
  public boolean equals(Object otherEndangered){
    if (!(otherEndangered instanceof Endangered)) {
      return false;
    } else {
      Endamgered newEndangered = (Endangered) otherEndangered;
      return this.getName().equals(newEndangered.getName()) &&
             this.getAge().equals(newEndangered.getAge()) &&
             this.getHealth().equals(newEndangered.getHealth())&&
             this.getId() == newAnimal.getId();
    }
  }
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, age, health, type) VALUES (:name, :age, :health, :type)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("age", this.age)
        .addParameter("health", this.health)
        .addParameter("type", this.type)
        .executeUpdate()
        .getKey();
    }
  }
  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM animals WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }


}
