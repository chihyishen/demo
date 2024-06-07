package uploadfilesys.demo.contollers;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import uploadfilesys.demo.models.Member;

@RestController
public class TestController 
{
  @GetMapping("/emp")
  public String GetAll() 
  {
    return "Hellooo";
  }

  @GetMapping("/emp/{memberId}")
  public String GetMember() 
  {
    return "GetOneMember";
  }

  @PostMapping("/emp")
  public Member CreateEmp(@RequestBody Member member) 
  {
    return member;
  }

  @PutMapping("/emp/{memberId}")
  public String UpdateEmp(@RequestBody Member member) 
  {
      var memberdata = "MemberID: "+Integer.toString(member.MemberId) + "ID: " + member.Id + "MemberMail: " +member.Email;
      return memberdata;
  }
  
  @DeleteMapping("/emp/{memberId}")
  public String DeleteEmp(@PathVariable int memberId)
  {
    return "Deleted";
  }
}

