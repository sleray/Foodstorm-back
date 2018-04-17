package fr.coachingdigital.foodstorm.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import fr.coachingdigital.foodstorm.FoodstormApplication;
import fr.coachingdigital.foodstorm.model.Family;
import fr.coachingdigital.foodstorm.model.Member;
import fr.coachingdigital.foodstorm.model.Role;

/**
 * Test CRUD around Member
 * @author Jean-Philippe
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = FoodstormApplication.class)
public class MemberServiceTest {
	
	@Autowired
	FamilyService familyService;
	@Autowired
	RoleService roleService;
	@Autowired
	MemberService memberService;
	
	@Test
	public void  crudTestSimple() {
		
		//Init
		Family family = new Family("FamilyTest");
		family = familyService.addFamily(family);
		
		Role role = new Role("RoleTest");
		role = roleService.addRole(role);
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		Member member = new Member("logTest","passwdTest","mail@mail.com",family, roles);
		member = memberService.addMember(member);
		
		// Try to find member by name
		Optional<Member> result = memberService.getMemberByLogin("logTest");
		Assert.assertTrue(result.isPresent());
		
		Assert.assertEquals(result.get().getFamily().getName(), family.getName());
		//Deleting
		memberService.deleteMemberByMember(member);
		familyService.deleteFamilyByFamily(family);
		roleService.deleteRoleByRole(role);
		
		Optional<Member> result2 = memberService.getMemberById(member.getId());
		Assert.assertFalse(result2.isPresent());
		
	}
}
