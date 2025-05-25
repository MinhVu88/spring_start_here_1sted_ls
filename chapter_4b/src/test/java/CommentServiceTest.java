import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.spring_start_here.models.Comment;
import com.spring_start_here.proxies.NotificationProxy;
import com.spring_start_here.repositories.CommentRepository;
import com.spring_start_here.services.CommentService;

public class CommentServiceTest {
	@Test
	@DisplayName("CommentService correctly delegates responsibilities to repo & proxy objects")
	void testCommentService() {
		var comment = mock(Comment.class);
		var commentRepo = mock(CommentRepository.class);
		var notification = mock(NotificationProxy.class);

		var commentService = new CommentService(commentRepo, notification);
		commentService.publishComment(comment);

		verify(commentRepo).storeComment(comment);
		verify(notification).sendNotification(comment);
	}
}
