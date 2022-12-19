package ync.pyb.repository;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.query.Param;

import ync.pyb.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	
	Boolean existsByMemberEmail(@NotBlank String memberEmail);
	
	
	@EntityGraph(attributePaths = {"roleSet"}, type = EntityGraphType.LOAD)
	@Query("select m from Member m where m.memberEmail = :memberEmail ")
	Optional<Member> findByMemberEmail(@Param("memberEmail") String memberEmail);
	
	@EntityGraph(attributePaths = {"roleSet"}, type = EntityGraphType.LOAD)
	@Query("select m from Member m where m.memberId = :memberId ")
	Optional<Member> findByMemberId(@Param("memberId") Long memberId);
}
