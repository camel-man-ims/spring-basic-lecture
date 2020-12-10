package inflearn.spring_basic_lecture.member;


public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
