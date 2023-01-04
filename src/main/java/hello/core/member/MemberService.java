package hello.core.member;

/**
 * 서비스 인터페이스, 추상화, 역할
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
