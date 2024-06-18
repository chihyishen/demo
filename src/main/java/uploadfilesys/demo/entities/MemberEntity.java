package uploadfilesys.demo.entities;

import java.math.BigInteger;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member_data")
@Getter @Setter
@NoArgsConstructor
public class MemberEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "會員編號",description = "會員編號")
    BigInteger memberId;

    @Column
    @Schema(name = "身分證字號",description = "身分證字號")
    String id;

    @Column
    @Schema(name = "電子郵件帳號",description = "電子郵件帳號")
    String email;
}
