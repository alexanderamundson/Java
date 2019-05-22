package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class LikeTest {

	@Test
	void testLike() {
		LocalDateTime date = LocalDateTime.now();
		Member m = new Member("matthew","ritter","matt", "mritter2283@gmail.com", date);
		Like like = new Like(m);
		assertTrue(like != null);
	}

	@Test
	void testGetUpVoter() {
		LocalDateTime date = LocalDateTime.now();
		Member m = new Member("matthew","ritter","matt", "mritter2283@gmail.com", date);
		Like like = new Like(m);
		assertEquals(m,like.getUpVoter());
	}

}
