package in.ashokit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Plan;
import in.ashokit.service.PlanService;

@RestController
public class PlanRestController {


	@Autowired
	PlanService planService;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getPlanCategories(){

		Map<Integer, String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<>(planCategories , HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){

		String msg="";

		boolean savedPlan = planService.savePlan(plan);
		if (savedPlan) {
			msg ="plan saved..";
		}else {
			msg = "Plan not saved..";
		}

		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<List<Plan>>(allPlans,HttpStatus.OK);
	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<Plan>(plan,HttpStatus.OK);
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean IsDeleted = planService.deletePlanByPlanId(planId);
		String respnseMsg = "";
		if (IsDeleted) {
			respnseMsg = "Plan Deleted";
		}else {
			respnseMsg = "Plan Not Deleted";
		}

		return new ResponseEntity<String>(respnseMsg,HttpStatus.OK);
	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){

		String msg="";

		boolean Isupdated = planService.updatePlan(plan);
		if (Isupdated) {
			msg ="plan updated..";
		}else {
			msg = "Plan not updated..";
		}

		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status){

		String msg="";

		boolean IsStatusChanged = planService.planStatusChange(planId,status);
		if (IsStatusChanged) {
			msg ="status changed..";
		}else {
			msg = "status not changed..";
		}

		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

}

