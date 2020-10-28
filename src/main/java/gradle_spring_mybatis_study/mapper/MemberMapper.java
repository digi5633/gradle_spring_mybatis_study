package gradle_spring_mybatis_study.mapper;

import java.util.List;

import gradle_spring_mybatis_study.dto.Member;

public interface MemberMapper {

	List<Member> selectMemberByAll();

	Member selectMemberByEmail(String email);

	int insertMember(Member member);

	int updateMember(Member member);

	int deleteMember(String email);

}
