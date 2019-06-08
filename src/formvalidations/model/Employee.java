package formvalidations.model;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="employee")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull(message="give numbers only")
	@Column(name = "id")
	int id;
	
	@Column(name="name",updatable = false,nullable=false)
	@NotEmpty(message="{NotEmpty.employee.name}")
	@Size(min=1,max=20)
	@Pattern(regexp="[^0-9]*")
	String name;
	
	@Column(name="dob",updatable = false,nullable=false)
	@NotEmpty(message="{NotEmpty.employee.dob}")
     String dob;
	
	@Column(name="qualification",updatable = false,nullable=false)
	@NotEmpty(message="{NotEmpty.employee.qualification}")
	String qualification;
	
	@Column(name="salary")
	@Pattern(regexp="[^A-Z,a-z]*")
	String salary;
	
	@Column(name="address")
	@NotEmpty(message="{NotEmpty.employee.address}")
	String address;

	 @Column(name="pic",nullable=false)
	@Lob @Basic(fetch = FetchType.LAZY)
	private byte[] pic;
	
	
	@Column(name="getpic",updatable = false,nullable=false)
	@Transient
	private String getpic;

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getGetpic() {
		return getpic;
	}

	public void setGetpic(String getpic) {
		this.getpic = getpic;
	}

	public Employee(int id, String name, String dob, String qualification, String salary, String address, byte[] pic,
			String getpic) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.qualification = qualification;
		this.salary = salary;
		this.address = address;
		this.pic = pic;
		this.getpic = getpic;
	}

	
	
	
	
	
	
	
	
	
	
}
