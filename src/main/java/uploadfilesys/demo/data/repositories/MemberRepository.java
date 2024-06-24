package uploadfilesys.demo.data.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uploadfilesys.demo.data.dao.MemberEntity;


@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, BigInteger>
{
}