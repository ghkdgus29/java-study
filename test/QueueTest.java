import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @DisplayName("큐에 값을 offer하여 저장하고, poll하여 꺼낸다.")
    @Test
    void offerAndPoll() {
        // given
        Queue queue = new Queue(5);

        // when
        queue.offer(1);
        int poll = queue.poll();

        // then
        assertThat(poll).isEqualTo(1);
    }

    @DisplayName("큐에서 poll을 하면 가장 처음 offer 한 값이 나온다.")
    @Test
    void multipleOfferAndPoll() {
        // given
        Queue queue = new Queue(5);
        queue.offer(1);
        queue.offer(2);

        // when
        int poll = queue.poll();

        // then
        assertThat(poll).isEqualTo(1);
    }

    @DisplayName("큐에서 여러번 poll을 할 수 있다.")
    @Test
    void multiplePoll() {
        // given
        Queue queue = new Queue(5);
        queue.offer(1);
        queue.offer(2);

        // when
        int poll1 = queue.poll();
        int poll2 = queue.poll();

        // then
        assertThat(poll1).isEqualTo(1);
        assertThat(poll2).isEqualTo(2);
    }

    @DisplayName("만약 생성할때 지정한 큐 크기보다 더 많이 offer 하면 큐 오버플로우 에러를 던진다.")
    @Test
    void queueOverflow() {
        // given
        Queue queue = new Queue(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        // when // then
        assertThatThrownBy(() -> queue.offer(4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("큐 오버플로우");
    }

    @DisplayName("만약 빈 큐에서 poll을 하면 큐 언더플로우 에러를 던진다.")
    @Test
    void stackUnderflow() {
        // given
        Queue queue = new Queue(3);

        // when // then
        assertThatThrownBy(() -> queue.poll())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("큐 언더플로우");
    }
}