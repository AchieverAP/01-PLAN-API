package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Plan;
import in.ashokit.entity.PlanCategory;
import in.ashokit.repository.PlanCategoryRepository;
import in.ashokit.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanCategoryRepository planCategoryRepository;
	
	@Autowired
	PlanRepository planRepository;
	
	@Override
	public Map<Integer, String> getPlanCategories() {
		// TODO Auto-generated method stub
		
		List<PlanCategory> planCategaories = planCategoryRepository.findAll();
		HashMap<Integer, String> allCategories = new HashMap<>();
		
		planCategaories.forEach(categaory -> {
			allCategories.put(categaory.getCategoryId(), categaory.getCategoryName());
		});
		return allCategories;
	}

	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
		Plan saved = planRepository.save(plan);
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		
		List<Plan> findAllPlans = planRepository.findAll();
		return findAllPlans;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		
		Optional<Plan> findById = planRepository.findById(planId);
		
		if (!findById.isEmpty()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		
		planRepository.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanByPlanId(Integer planId) {
		// TODO Auto-generated method stub
		
		boolean status =false;
		try {
			planRepository.deleteById(planId);
			status = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		// TODO Auto-generated method stub
		
		Optional<Plan> findById = planRepository.findById(planId);
		if (findById.isPresent()) {
			Plan plan = findById.get();
			plan.setPlanId(planId);
			plan.setActivSwitch(status);
			planRepository.save(plan);
			return true;
		}
		return false ;
	}

}
