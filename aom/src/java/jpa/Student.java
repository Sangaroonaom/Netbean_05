/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TMN
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStdid", query = "SELECT s FROM Student s WHERE s.stdid = :stdid"),
    @NamedQuery(name = "Student.findByStdFname", query = "SELECT s FROM Student s WHERE s.stdFname = :stdFname"),
    @NamedQuery(name = "Student.findByStdLname", query = "SELECT s FROM Student s WHERE s.stdLname = :stdLname"),
    @NamedQuery(name = "Student.findByStdBirthday", query = "SELECT s FROM Student s WHERE s.stdBirthday = :stdBirthday"),
    @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address"),
    @NamedQuery(name = "Student.findByPhonenumber", query = "SELECT s FROM Student s WHERE s.phonenumber = :phonenumber"),
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Std_id")
    private Integer stdid;
    @Size(max = 40)
    @Column(name = "Std_Fname")
    private String stdFname;
    @Size(max = 40)
    @Column(name = "Std_Lname")
    private String stdLname;
    @Size(max = 40)
    @Column(name = "Std_Birthday")
    private String stdBirthday;
    @Size(max = 40)
    @Column(name = "Address")
    private String address;
    @Size(max = 40)
    @Column(name = "Phonenumber")
    private String phonenumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "Email")
    private String email;
    @JoinColumn(name = "Courses_id", referencedColumnName = "Courses_id")
    @ManyToOne
    private Courses coursesid;
    @JoinColumn(name = "Sex_id", referencedColumnName = "Sex_id")
    @ManyToOne(optional = false)
    private Gender sexid;

    public Student() {
    }

    public Student(Integer stdid) {
        this.stdid = stdid;
    }

    public Integer getStdid() {
        return stdid;
    }

    public void setStdid(Integer stdid) {
        this.stdid = stdid;
    }

    public String getStdFname() {
        return stdFname;
    }

    public void setStdFname(String stdFname) {
        this.stdFname = stdFname;
    }

    public String getStdLname() {
        return stdLname;
    }

    public void setStdLname(String stdLname) {
        this.stdLname = stdLname;
    }

    public String getStdBirthday() {
        return stdBirthday;
    }

    public void setStdBirthday(String stdBirthday) {
        this.stdBirthday = stdBirthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Courses getCoursesid() {
        return coursesid;
    }

    public void setCoursesid(Courses coursesid) {
        this.coursesid = coursesid;
    }

    public Gender getSexid() {
        return sexid;
    }

    public void setSexid(Gender sexid) {
        this.sexid = sexid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdid != null ? stdid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.stdid == null && other.stdid != null) || (this.stdid != null && !this.stdid.equals(other.stdid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Student[ stdid=" + stdid + " ]";
    }
    
}
