package uploadfilesys.demo.models;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class MemberModel 
{
    public BigInteger memberId;

    public String id;
    
    public String email;
}
