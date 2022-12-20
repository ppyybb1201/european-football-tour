package european.football.tour.repository;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import european.football.tour.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.query.Param;

public interface MemberRepo extends JpaRepository<Member, Long>{
	
	
	Boolean existsByMemberEmail(@NotBlank String memberEmail);
	
	
	@EntityGraph(attributePaths = {"roleSet"}, type = EntityGraphType.LOAD)
	@Query("SELECT m FROM Member m WHERE m.memberEmail = :memberEmail ")
	Optional<Member> findByMemberEmail(@Param("memberEmail") String memberEmail);
	
	@EntityGraph(attributePaths = {"roleSet"}, type = EntityGraphType.LOAD)
	@Query("SELECT m FROM Member m WHERE m.memberId = :memberId ")
	Optional<Member> findByMemberId(@Param("memberId") Long memberId);


}
