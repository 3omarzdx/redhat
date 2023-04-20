package tools2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class calc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id ;
  private int num1 ;
  private int num2 ;
  private String op ;
  
  public void setId(long id )
  {
	  this.id = id ;
  }
  public long getId()
  {
	  return id ;
  }
  
public int getNum1() {
	return num1;
}
public void setNum1(int num1) {
	this.num1 = num1;
}
public int getNum2() {
	return num2;
}
public void setNum2(int num2) {
	this.num2 = num2;
}
public String getOp() {
	return op;
}
public void setOp(String op) {
	this.op = op;
}
  
  
  
}
