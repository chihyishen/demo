package uploadfilesys.demo.services.member;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uploadfilesys.demo.data.repositories.*;
import uploadfilesys.demo.data.dao.*;
import uploadfilesys.demo.models.MemberModel;

@Service
public class MemberService implements MemberInterface
{
    @Autowired
    private MemberRepository memberRepository;

    private MemberModel convertToModel(MemberEntity entity) {
        MemberModel model = new MemberModel();
        model.setMemberId(entity.getMemberId());
        model.setId(entity.getId());
        model.setEmail(entity.getEmail());
        return model;
    }

    private MemberEntity convertToEntity(MemberModel model) {
        MemberEntity entity = new MemberEntity();
        entity.setMemberId(model.getMemberId());
        entity.setId(model.getId());
        entity.setEmail(model.getEmail());
        return entity;
    }

    @Override
    public List<MemberModel> getAll()
    {
        return memberRepository.findAll().stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public MemberModel getById(BigInteger memberId)
    {
        return memberRepository.findById(memberId)
                .map(this::convertToModel)
                .orElse(null);
    }
    
    @Override
    public MemberModel create(MemberModel memberModel)
    {
        MemberEntity entity = convertToEntity(memberModel);
        MemberEntity savedEntity = memberRepository.save(entity);
        return convertToModel(savedEntity);
    }
    
    @Override
    public MemberModel update(BigInteger memberId, MemberModel memberModel)
    {
        if (memberRepository.existsById(memberId)) {
            MemberEntity entity = convertToEntity(memberModel);
            entity.setMemberId(memberId); // Ensure the ID is correct
            MemberEntity updatedEntity = memberRepository.save(entity);
            return convertToModel(updatedEntity);
        }
        return null;
    }
    
    @Override
    public void delete(BigInteger memberId)
    {
        memberRepository.deleteById(memberId);
    }
    
} 