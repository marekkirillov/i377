package main;
import  javax.persistence.*;

@Entity
public class Unit {
	
	@Id
    @SequenceGenerator(name = "my_seq", sequenceName = "SEQ1", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
	private Long id;
	
	private String name;
	private String code;
	
	@ManyToOne
	private Unit superunit;
	
	public Unit(){}//Argumentideta konstruktor
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Unit getUnit() {
        return superunit;
    }

    public void setSuperUnit(Unit superunit) {
        this.superunit = superunit;
    }
	
}