package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

	@Autowired
	JpaMemoRepository jpaMemoRepository;

	@Test
	void insertMemoTest() {
		//given
		Memo newMemo = new Memo(10, "this is jpa Memo");

		//when
		jpaMemoRepository.save(newMemo);

		//then
		List<Memo> memoList = jpaMemoRepository.findAll();
		assertTrue(memoList.size() > 0);
	}

	@Test
	void findByTest() {
	    //given
		Memo newMemo = new Memo(10, "this is jpa Memo");
	    //when
		Memo memo = jpaMemoRepository.save(newMemo);

		//then
		Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
		assertEquals("this is jpa Memo", result.get().getText());
	}
}
