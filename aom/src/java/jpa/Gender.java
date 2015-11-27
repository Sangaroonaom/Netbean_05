/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TMN
 */
@Entity
@Table(name = "gender")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g"),
    @NamedQuery(name = "Gender.findBySexid", query = "SELECT g FROM Gender g WHERE g.sexid = :sexid"),
    @NamedQuery(name = "Gender.findBySexname", query = "SELECT g FROM Gender g WHERE g.sexname = :sexname")})
public class Gender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sex_id")
    private Integer sexid;
    @Size(max = 40)
    @Column(name = "Sex_name")
    private String sexname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexid")
    private Collection<Teacher> teacherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexid")
    private Collection<Student> studentCollection;

    public Gender() {
    }

    public Gender(Integer sexid) {
        this.sexid = sexid;
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }

    public String getSexname() {
        return sexname;
    }

    public void setSexname(String sexname) {
        this.sexname = sexname;
    }

    @XmlTransient
    public Collection<Teacher> getTeacherCollection() {
        return teacherCollection;
    }

    public void setTeacherCollection(Collection<Teacher> teacherCollection) {
        this.teacherCollection = teacherCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sexid != null ? sexid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gender)) {
            return false;
        }
        Gender other = (Gender) object;
        if ((this.sexid == null && other.sexid != null) || (this.sexid != null && !this.sexid.equals(other.sexid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Gender[ sexid=" + sexid + " ]";
    }
    
}
