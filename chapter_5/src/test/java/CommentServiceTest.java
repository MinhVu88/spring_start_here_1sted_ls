import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring_start_here.Config;
import com.spring_start_here.services.CommentService0;
import com.spring_start_here.services.CommentService5;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Config.class})
public class CommentServiceTest {
	@Autowired
	private ApplicationContext context;

	@Test
	@DisplayName("verify that cs0 & cs1 refer to the same singleton-scoped commentService0 bean in the Spring context")
	void testCommentService0() {
		var cs0 = context.getBean("commentService0", CommentService0.class);
		var cs1 = context.getBean("commentService0", CommentService0.class);
		assertEquals(cs0, cs1);
	}

	@Test
	@DisplayName("verify that cs0 & cs1 refer to distinct, prototype-scoped CommentService5 beans in the Spring context")
	void testCommentService5() {
		var cs0 = context.getBean("commentService5", CommentService5.class);
		var cs1 = context.getBean("commentService5", CommentService5.class);
		assertNotEquals(cs0, cs1);
	}
}
