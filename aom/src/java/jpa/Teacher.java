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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacherid", query = "SELECT t FROM Teacher t WHERE t.teacherid = :teacherid"),
    @NamedQuery(name = "Teacher.findByTeacherFname", query = "SELECT t FROM Teacher t WHERE t.teacherFname = :teacherFname"),
    @NamedQuery(name = "Teacher.findByTeacherLname", query = "SELECT t FROM Teacher t WHERE t.teacherLname = :teacherLname"),
    @NamedQuery(name = "Teacher.findByPhonenumber", query = "SELECT t FROM Teacher t WHERE t.phonenumber = :phonenumber"),
    @NamedQuery(name = "Teacher.findByEmail", query = "SELECT t FROM Teacher t WHERE t.email = :email")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Teacher_id")
    private Integer teacherid;
    @Size(max = 40)
    @Column(name = "Teacher_Fname")
    private String teacherFname;
    @Size(max = 40)
    @Column(name = "Teacher_Lname")
    private String teacherLname;
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

    public Teacher() {
    }

    public Teacher(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeacherFname() {
        return teacherFname;
    }

    public void setTeacherFname(String teacherFname) {
        this.teacherFname = teacherFname;
    }

    public String getTeacherLname() {
        return teacherLname;
    }

    public void setTeacherLname(String teacherLname) {
        this.teacherLname = teacherLname;
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
        hash += (teacherid != null ? teacherid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherid == null && other.teacherid != null) || (this.teacherid != null && !this.teacherid.equals(other.teacherid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Teacher[ teacherid=" + teacherid + " ]";
    }
    
}
