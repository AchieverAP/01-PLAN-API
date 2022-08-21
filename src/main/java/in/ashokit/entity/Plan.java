package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_MASTER")
public class Plan {
	
	public Plan() {
		
	}

	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer PlanId;
	
	@Column(name = "PLAN_NAME")
	private String PlanName;
	
	@Column(name = "PLAN_START_DATE")
	private LocalDate planStarDate;
	
	@Column(name = "PLAN_END_DATE")
	private LocalDate planENDate;
	
	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name = "ACTIV_SW")
	private String activSwitch;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "CREATED_DATE" , updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name = "UPDATED_DATE" , insertable = false )
	@UpdateTimestamp
	private LocalDate updateDate;

	public Integer getPlanId() {
		return PlanId;
	}

	public void setPlanId(Integer planId) {
		PlanId = planId;
	}

	public String getPlanName() {
		return PlanName;
	}

	public void setPlanName(String planName) {
		PlanName = planName;
	}

	public LocalDate getPlanStarDate() {
		return planStarDate;
	}

	public void setPlanStarDate(LocalDate planStarDate) {
		this.planStarDate = planStarDate;
	}

	public LocalDate getPlanENDate() {
		return planENDate;
	}

	public void setPlanENDate(LocalDate planENDate) {
		this.planENDate = planENDate;
	}

	public Integer getPlanCategoryId() {
		return planCategoryId;
	}

	public void setPlanCategoryId(Integer planCategoryId) {
		this.planCategoryId = planCategoryId;
	}

	public String getActivSwitch() {
		return activSwitch;
	}

	public void setActivSwitch(String activSwitch) {
		this.activSwitch = activSwitch;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
  