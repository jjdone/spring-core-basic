package hello.core.member;

/**
 * 서비스 구현체
 */
public class MemberServiceImpl implements MemberService{

    /**
     * MemberServiceImpl는 MemberRepository(인터페이스)와 MemoryMemberRepository(구현체) 모두 의존하고 있다.
     * 그리고 그것은 DIP(의존관계 역전 원칙)에 위배된다.
     */
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
