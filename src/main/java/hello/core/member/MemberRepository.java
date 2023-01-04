package hello.core.member;

/**
 * 저장소 인터페이스, 추상화, 역할
 */
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
