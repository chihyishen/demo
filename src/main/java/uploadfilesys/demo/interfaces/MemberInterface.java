package uploadfilesys.demo.interfaces;

import java.math.BigInteger;
import java.util.List;
import uploadfilesys.demo.models.MemberModel;
public interface MemberInterface 
{
    List<MemberModel> getAll();
    MemberModel getById(BigInteger memberId); 
    MemberModel create(MemberModel memberModel);
    MemberModel update(BigInteger memberId, MemberModel memberModel);
    void delete(BigInteger memberId);
} 