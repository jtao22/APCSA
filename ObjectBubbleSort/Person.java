import java.io.*; 
import java.util.*; 
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class Person{
	private String name;
	private int age;
	private Double weight;
	public Person(){
		name = "";
		age = 0;
		weight = 0.0;
	}
	public Person(String n, int a, double w){
		name = n;
		age = a;
		weight = w;
	}
	public void setName(String n){
		name = n;
	}
	public void setAge(int a){
		age = a;
	}
	public void setWeight(Double w){
		weight = w;
	}
	public String getName(){
		String s = name;
		return s;
	}
	public int getAge(){
		int i = age;
		return i;
	}
	public Double getWeight(){
		Double d = weight;
		return d;
	}
	public void printperson(){
		System.out.print("{" + name + ", " + age + ", " + weight + "}");
	}
	public boolean mustswap(Person p){
		var namecompare = name.compareTo(p.getName());
		if(namecompare > 0){
			return true;
		}
		else if (namecompare == 0){
			if(age > p.getAge()){
				return true;
			}
			else if (age == p.getAge()){
				if(weight > p.getWeight()){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}