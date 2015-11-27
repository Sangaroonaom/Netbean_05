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
import javax.persistence.OneToOne;
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
@Table(name = "courses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courses.findAll", query = "SELECT c FROM Courses c"),
    @NamedQuery(name = "Courses.findByCoursesid", query = "SELECT c FROM Courses c WHERE c.coursesid = :coursesid"),
    @NamedQuery(name = "Courses.findByCoursesname", query = "SELECT c FROM Courses c WHERE c.coursesname = :coursesname"),
    @NamedQuery(name = "Courses.findByCoursesstart", query = "SELECT c FROM Courses c WHERE c.coursesstart = :coursesstart"),
    @NamedQuery(name = "Courses.findByCoursesunits", query = "SELECT c FROM Courses c WHERE c.coursesunits = :coursesunits")})
public class Courses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Courses_id")
    private Integer coursesid;
    @Size(max = 40)
    @Column(name = "Courses_name")
    private String coursesname;
    @Size(max = 40)
    @Column(name = "Courses_start")
    private String coursesstart;
    @Size(max = 40)
    @Column(name = "Courses_units")
    private String coursesunits;
    @OneToMany(mappedBy = "coursesid")
    private Collection<Teacher> teacherCollection;
    @OneToMany(mappedBy = "coursesid")
    private Collection<Student> studentCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "courses")
    private CourseDetail courseDetail;

    public Courses() {
    }

    public Courses(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public Integer getCoursesid() {
        return coursesid;
    }

    public void setCoursesid(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public String getCoursesname() {
        return coursesname;
    }

    public void setCoursesname(String coursesname) {
        this.coursesname = coursesname;
    }

    public String getCoursesstart() {
        return coursesstart;
    }

    public void setCoursesstart(String coursesstart) {
        this.coursesstart = coursesstart;
    }

    public String getCoursesunits() {
        return coursesunits;
    }

    public void setCoursesunits(String coursesunits) {
        this.coursesunits = coursesunits;
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

    public CourseDetail getCourseDetail() {
        return courseDetail;
    }

    public void setCourseDetail(CourseDetail courseDetail) {
        this.courseDetail = courseDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursesid != null ? coursesid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.coursesid == null && other.coursesid != null) || (this.coursesid != null && !this.coursesid.equals(other.coursesid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Courses[ coursesid=" + coursesid + " ]";
    }
    
}
