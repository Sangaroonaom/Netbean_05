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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TMN
 */
@Entity
@Table(name = "course_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseDetail.findAll", query = "SELECT c FROM CourseDetail c"),
    @NamedQuery(name = "CourseDetail.findByCourescost", query = "SELECT c FROM CourseDetail c WHERE c.courescost = :courescost"),
    @NamedQuery(name = "CourseDetail.findByCoursesid", query = "SELECT c FROM CourseDetail c WHERE c.coursesid = :coursesid")})
public class CourseDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 40)
    @Column(name = "Coures_cost")
    private String courescost;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Courses_id")
    private Integer coursesid;
    @JoinColumn(name = "Courses_id", referencedColumnName = "Courses_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Courses courses;

    public CourseDetail() {
    }

    public CourseDetail(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public String getCourescost() {
        return courescost;
    }

    public void setCourescost(String courescost) {
        this.courescost = courescost;
    }

    public Integer getCoursesid() {
        return coursesid;
    }

    public void setCoursesid(Integer coursesid) {
        this.coursesid = coursesid;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
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
        if (!(object instanceof CourseDetail)) {
            return false;
        }
        CourseDetail other = (CourseDetail) object;
        if ((this.coursesid == null && other.coursesid != null) || (this.coursesid != null && !this.coursesid.equals(other.coursesid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.CourseDetail[ coursesid=" + coursesid + " ]";
    }
    
}
