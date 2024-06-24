package uploadfilesys.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import uploadfilesys.demo.models.MemberModel;
import uploadfilesys.demo.servies.MemberService;

import java.math.BigInteger;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/emp")
@Tag(name = "Member Api")
@CrossOrigin(origins = "*")
public class TestController 
{
  @Autowired
  private MemberService memberService;
  
  @GetMapping()
  @Operation(summary = "取得會員列表")
  public List<MemberModel> getAllMembers() 
  {
    return memberService.getAll();
  }

  @GetMapping("/{memberId}")
  @Operation(summary = "取得單一會員資料")
  public ResponseEntity<MemberModel> getMemberById(@PathVariable BigInteger memberId) 
  {
      MemberModel member = memberService.getById(memberId);
      return member != null ? ResponseEntity.ok(member) : ResponseEntity.notFound().build();
  }

  @PostMapping()
  @Operation(summary = "新增會員")
  public MemberModel createEmp(@RequestBody MemberModel member) 
  {
    return memberService.create(member);
  }

  @PutMapping("/{memberId}")
  @Operation(summary = "修改會員")
  public ResponseEntity<MemberModel> updateMember(@PathVariable BigInteger memberId, @RequestBody MemberModel member) 
  {
    MemberModel updatedMember = memberService.update(memberId, member);
    return member != null ? ResponseEntity.ok(updatedMember) : ResponseEntity.notFound().build();
  }
  
  @DeleteMapping("/{memberId}")
  @Operation(summary = "刪除會員")
  public ResponseEntity<Void> deleteMember(@PathVariable BigInteger memberId)
  {
    memberService.delete(memberId);
    return ResponseEntity.noContent().build();
  }
}
