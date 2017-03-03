import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Animal {
  public String name;
  public int id;

  public String getName(){
    return name;
  }
  public int getId(){
    return id;
  }
}
